##flask-socketio使用的小结

1.安装

	使用pip install flask-socketio
2.使用

	服务器使用的是flask_socketio,而客户端使用的是socket.io.
	socket.io有两个版本1.x和2.x，flask_socketio只能与兼容1.x
3.例子

- 这是服务端的代码 

	
		from flask import Flask, render_template
		from flask_socketio import SocketIO

		app = Flask(__name__)
		app.config['SECRET_KEY'] = 'secret!'
		socketio = SocketIO(app)
	
		@app.route('/')	
		def index():
			return render_template('index.html')
		@socketio.on('clinet_connect')
		def get_connect(msg):
			print msg.data
		
		if __name__ == '__main__':
    		socketio.run(app)

	注意网络服务器的启动。函数socketio.run()封装了网络服务器的启动部分，并且代替了flask开发服务器的标准启动语句app.run()。
	Socketio的通信基于事件，不同名称的事件对应不同的处理函数，类似于Web服务器处理路由的机制。

- 这是客户端的代码

 		<script type="text/javascript" scr="//cdn.cloudflare.com/ajax/libs/socket.io/1.3.6/socket.io.min.js"></script>
		<script type="text/javascript" charset="utf-8">
    	var socket = io.connect(location.protocol + '//' + document.domain + ':' + location.port);
    	socket.on('connect', function() {
		socket.emit('client_client', {data: 'I/'m connected!'});
    	});
		</script>
		
	- io.connect() 建立连接
	- socket.on() 监听事件
    - socket.emit() 发送消息

- 接受消息

		在使用SocketIO的时候，消息将被作为活动(event)的两端接收。在客户端使用JavaScript回叫信号。
		使用Flask-SocketIO服务器，需要为这些活动注册处理器(handler)，类似于视图函数怎样处理路由
		列如：socketio.on('message'),socketio.on('json'),socketio.on('connect'),socketio.on('disconnect')...
		message 代表接受字符串，json接受json格式,connect是连接，disconect是断开连接，这几个都是内置事件。
		自定义事件是可以接受任意类型的参数。

- 发送消息

		SocketIO活动处理函数可以凭借send()函数和emit()函数来连接客户端。send()是用在未命名的事件上，emit()是用在已命名的事件上。

- 除了使用路由方式定义事件之外还可以使用基于类的命名空间来实现，方法一般以on_开头这是规定，不能乱写。
	
		from flask_socketio import Namespace
		
		class my_Namespace(Namespace):
			def on_connect(self):
				print 'Connected'
			def on_disconnect(self):
				print 'can not connected '

- 参考材料 
- 
- 1.[使用Flask-Socketio进行WebSocket通信](http://www.tuicool.com/articles/jABnAzU)
- 2.[flask-SocketIO官方文档翻译](http://www.th7.cn/Program/Python/201704/1150585.shtml)
- 3.[flask-Socketio官方文档](http://flask-socketio.readthedocs.io/en/latest/)