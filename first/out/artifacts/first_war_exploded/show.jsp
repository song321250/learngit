<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/5/22
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/getAjax.js"></script>
<body>
    <table border="1">
        <tr>
            <td>学号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>
    <c:forEach items="${listPage.list}" var="person" >
        <tr>
            <td>${person.pid}</td>
            <td>${person.username}</td>
            <td>${person.password}</td>
            <td><a href="ser?op=del&pid=${person.pid}">删除</a>  <a href="ser?op=getOne&pid=${person.pid}">修改</a></td>
        </tr>

    </c:forEach>
        <tr>
            <td>总共${listPage.pageCount}条</td>
            <td><a href="ser?op=page&pageIndex=${listPage.pageIndex+1}">下一页</a></td>
            <td><a href="ser?op=page&pageIndex=${listPage.pageIndex-1}">上一页</a></td>
        </tr>
    </table>
</body>
</html>
