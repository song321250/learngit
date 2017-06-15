<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/5/18
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/getAjax.js" type="text/javascript"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
   $(document).ready(function () {
       $("input[name=username]").blur(function () {
           var  ss =$(this).val();
           $.post("ser?op=ajax",{fpvalue:ss},function (mess) {
               $("#myspan").html(mess);
           });
       })
   })
</script>
<html>
  <head>
    <title>this is my first idea project</title>
  </head>

  <body >
    <form action="ser?op=add" method="post" >
        用户名：<input type="text" name="username" /><br/><span id="myspan"></span><br/>
        密码：<input type="password" name="passwd"/><br>
        <input type="submit" value="注册" onclick="demo()"/>
    </form>
  </body>
</html>


