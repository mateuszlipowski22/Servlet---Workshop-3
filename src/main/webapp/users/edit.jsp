<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 14.06.2022
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<div class="card-body">
<form action="/user/edit" method="post" class="form-group">
    <h3 class="m-0 font-weight-bold text-primary">User ID = ${userEdit.getId()} Update</h3><br>
    <input type="hidden"  name="idEdit" value=${userEdit.getId()}>
    <label>User Name</label><br>
    <input type="text" name="userEditName" value="${userEdit.getUserName()}" class="form-control"><br>
    <label>Email address</label><br>
    <input type="text" name="emailEdit" value="${userEdit.getEmail()}" class="form-control"><br>
    <label>Password</label><br>
    <input type="text" name="passwordEdit" class="form-control"><br>
    <button type="submit" class="btn btn-primary">Edit</button>
</form>
</div>

</body>
</html>
