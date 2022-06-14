<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 14.06.2022
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="/login" method="post">
    <label>Username</label><br>
    <input type="text"  name="username"/><br>
    <label>Password</label><br>
    <input name="password" type="password"/><br>
    <button type="submit">Login</button><br>
</form>


</body>
</html>
