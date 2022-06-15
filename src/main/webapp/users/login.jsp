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
<div class="card-body">
    <form action="/login" method="post" class="form-group">
        <label>Username</label><br>
        <input type="text" name="username" class="form-control"/><br>
        <label>Password</label><br>
        <input name="password" type="password"class="form-control"/><br>
        <button type="submit" class="btn btn-primary">Login</button>
        <br>
    </form>
</div>

</body>
</html>
