<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/6/7
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${fileMap}" var ="file">
            <c:url value="ser?op=dd" var ="downurl">
                <c:param name="filename" value="${file.key}"></c:param>
            </c:url>
        ${file.value}<a href="${downurl}">下载</a><br/>
    </c:forEach>
</body>
</html>
