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
<div class="card-body">
    <form action="/user/add" method="post" class="form-group">
        <h3 class="m-0 font-weight-bold text-primary">Add user</h3>
        <label>User Name</label><br>
        <input type="text" name="userName" class="form-control"><br>
        <label>Email address</label><br>
        <input type="text" name="email" class="form-control"><br>
        <label>Password</label><br>
        <input type="text" name="password" class="form-control"><br>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

</body>
</html>
