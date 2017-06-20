#coding=utf-8
from flask_socketio import SocketIO,emit,Namespace,send
from flask import Flask,request,make_response
import redis
import time
import json
async_mode=None
thread = None
app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret!'
socketio = SocketIO(app=app,async_mode=async_mode)
r = redis.Redis(host='127.0.0.1', port=6379)
def background_thread():

    '''
    处理redis队列
    '''
    while True:
        mess=''
        socketio.sleep(1)
        start =time.time()
        message = r.blpop('data')
        if isinstance(message, tuple):
            mess = message[1].decode('unicode-escape')
            mess =mess.encode("utf-8")
            print mess
        else:

            mess = message.decode('unicode-escape')
            mess = mess.encode("utf-8")
            print mess

        # if message is not None:
        #     # print message
        #     if isinstance(message,tuple):
        #         mess = message[1].decode('unicode-escape')
        #         mess =mess.encode("utf-8")
        #         print mess
        #     else:
        #         mess = message.decode('unicode-escape')
        #         mess = mess.encode("utf-8")
        #         print mess
        # print mess
        # if  mess != '':
        socketio.emit("my_response", {'data': mess}, namespace='/test')


        end = time.time()
        print (end-start)

def pre_handler(fun):
    pass
class Send_App(Namespace):

    '''
    创建一个基于类的命名空间
    方法以on_开头，这是规定，不能乱来
    发送是先会经过connect这个连接
    '''
    def on_my_connect(self,msg):
        print json.dumps(msg).decode('unicode-escape')
        emit('my_response',{'data':'OK'})

    def on_disconnect(self):
        print 111
        print "can\'t Connected"

    def on_error(e):
        print request.event['message']
        print request.event['args']
    # def on_my_ping(self):
    #     emit("my_response", {'data': mess})
    def on_error_default(e):
        print request.event['message']
        print request.event['args']

socketio.on_namespace(Send_App('/test'))
if __name__=="__main__":
    global thread
    if thread is None:
        thread = socketio.start_background_task(target=background_thread)
    socketio.run(app,port=9999,host='0.0.0.0')


