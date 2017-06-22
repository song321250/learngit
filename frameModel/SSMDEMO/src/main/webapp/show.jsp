<%@ page import="javax.naming.Context" %><%--
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
            <td>操作</td>
        </tr>
        <c:forEach items="${pages.list}" var="person">
            <tr>
                <td>${person.pid}</td>
                <td>${person.username}</td>
                <td>${person.password}</td>
                <td><a href="/SSMDEMO/person/del?pid=${person.pid}">删除</a> <a href="/SSMDEMO/person/getOne?pid=${person.pid}">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="/SSMDEMO/person/findPage?pageIndex=${pages.pageIndex+1}">下一页</a></td>
            <td><a href="/SSMDEMO/person/findPage?pageIndex=${pages.pageIndex-1}">上一页</a></td>
        </tr>
    </table>

</body>
</html>
