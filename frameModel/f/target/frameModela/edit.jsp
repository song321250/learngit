<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/6/13
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="update" method="post">
        <input type="hidden" value="${person.pid}" name="person.pid">
        <input type="text" value="${person.username}" name="person.username"><br>
        <input type="text" value="${person.password}" name="person.password"><br>
        <input type="submit"  value="update"/>
    </form>
</body>
</html>
