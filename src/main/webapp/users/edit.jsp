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

<form action="/user/edit" method="post">
    <label>User Update ${userEdit.getId()}</label><br>
    <input type="hidden"  name="idEdit" value=${userEdit.getId()}>
    <label>User Name</label><br>
    <input type="text" name="userEditName" value="${userEdit.getUserName()}"><br>
    <label>Email address</label><br>
    <input type="text" name="emailEdit" value="${userEdit.getEmail()}"><br>
    <label>Password</label><br>
    <input type="text" name="passwordEdit"><br>
    <input type="submit" value="Edit">
</form>

</body>
</html>
