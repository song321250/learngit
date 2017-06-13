<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h2>Hello World!</h2>
 <c:forEach items="${list}" var ="person">
     ${person.pid}--${person.username}--${person.password}<br/>
 </c:forEach>
</body>
</html>
