<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<header>

    <meta charset="utf-8" >
</header>
<body>
<h2>Hello World!</h2>

<table align="center" border="1">
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${page.list}" var ="person">
        <tr>
        <td>${person.username}</td>
        <td>${person.password}</td>
        <td><a href="edit?person.pid=${person.pid}">修改</a>  <a href="del1?person.pid=${person.pid}">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="page?page.pageIndex=${page.pageIndex+1}">下一页</a></td>
        <td><a href="page?page.pageIndex=${page.pageIndex-1}">上一页</a></td>
    </tr>
</table>

</body>
</html>
