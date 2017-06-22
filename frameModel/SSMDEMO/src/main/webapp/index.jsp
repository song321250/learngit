<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"> </script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#username").blur(function () {
            var name = $(this).val();
           $.post("person/ajaxAction",{"username":name},function (result) {
                $("#sp").html(result);
            });
        });
    })

</script>
<body>
    <form action="person/findPage" method="post">
        <input type="text" name="username" id="username"><span id="sp"></span><br>
        <input type="password" name="password"><br>
        <input type="submit" value="新增"><br>
    </form>
</body>
</html>
