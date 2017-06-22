<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/6/20
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="../person/update" method="post">
        <input type="hidden" value="${person.pid}" name="pid">
        <input type="text" value="${person.username}" name="username"><br>
        <input type="text" value="${person.password}" name="password"><br>
        <input type="submit" value="修改"><br>
    </form>
</body>
</html>
