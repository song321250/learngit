<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/6/20
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table align="center" border="1">
        <tr>
            <td>用户id</td>
            <td>用户名</td>
            <td>密码</td>
        </tr>
        <c:forEach items="${list}" var="person">
            <tr>
                <td>${person.pid}</td>
                <td>${person.username}</td>
                <td>${person.password}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
