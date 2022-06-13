<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 13.06.2022
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>

<form action="/user/add" method="post">
    <label>Add user</label><br>
    <label>User Name</label><br>
    <input type="text" name="userName"><br>
    <label>Email address</label><br>
    <input type="text" name="email"><br>
    <label>Password</label><br>
    <input type="text" name="password"><br>
    <input type="submit" value="Save">
</form>

</body>
</html>
