<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <form action="${pageContext.request.contextPath}/add" method="post">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="新增"><br>
    </form>
</body>
</html>
