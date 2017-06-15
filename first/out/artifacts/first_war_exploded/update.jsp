<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/6/5
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>update</h1>
    <form action="ser?op=update" method="post">
            <input type="hidden" value="${person.pid}" name="pid"/><br/>
           用户名： <input  type="text" value="${person.username}" name="username"/><br/>
           密码：<input type="text" value="${person.password}" name="password"/><br/>
            <input type="submit" value="修改"/>
    </form>
</body>
</html>
