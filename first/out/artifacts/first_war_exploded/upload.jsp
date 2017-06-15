<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/6/6
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="ser?op=upload" method="post" enctype="multipart/form-data">
        <input type="text"  name ="sss" /><br>
        <input type="file" name="filename" /><br>
        <input type="file" name="filename1"><br/>
        <input type="submit" value="上传"/>
    </form>
    <a href="ser?op=down">下载</a>
</body>
</html>
