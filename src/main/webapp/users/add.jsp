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
        <h3 class="m-0 font-weight-bold text-primary">Add user</h3><br>
        <label>Username</label><br>
        <input type="text" name="userName" class="form-control">
        <c:choose>
            <c:when test="${usernameTaken=='1'}">
                <h6 class="m-0 font-weight-bold text-primary">Username already exist</h6>
            </c:when>
        </c:choose><br>
        <label>Email address</label><br>
        <input type="text" name="email" class="form-control">
        <c:choose>
            <c:when test="${incorrectEmail=='1'}">
                <h6 class="m-0 font-weight-bold text-primary">Incorrect email address</h6>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${emailTaken=='1'}">
                <h6 class="m-0 font-weight-bold text-primary">Email address already exist</h6>
            </c:when>
        </c:choose><br>
        <label>Password</label><br>
        <input type="text" name="password" class="form-control">
        <c:choose>
            <c:when test="${emptyField=='1'}">
                <h6 class="m-0 font-weight-bold text-primary">Username, email address or password cannot be empty</h6>
            </c:when>
        </c:choose><br>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

</body>
</html>
