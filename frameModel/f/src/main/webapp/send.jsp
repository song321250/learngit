<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/6/9
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#user").blur(function () {
            var  value = $(this).val();
            console.log(value);
            $.ajax(
                    {
                        url: "ajaxTest",
                        type:"GET",
                        data:"username="+value,
                        success:function (result) {
                            $("#spanText").html(result);
                        }});
        });
    })

</script>
<body>
    <form action="wc" method="post">
        请输入用户名：<input type="text" name="person.username" id ="user"/><br><span id="spanText"></span><br>
        请输入密码：<input type="password" name="person.password">
        <input type="submit" value="send"/><br>
    </form>
</body>
</html>

