<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17 0017
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="req" method="get">
    用户名：<input type="text" name="uname" value=""><br>
    密  码：<input type="password" name="pwd" value=""><br>
    爱好：<br>
    <input type="checkbox" name="fav" value="1">唱歌<br>
    <input type="checkbox" name="fav" value="2">跳舞<br>
    <input type="checkbox" name="fav" value="3">游泳<br>
    <input type="submit" value="登录">
</form>

</body>
</html>
