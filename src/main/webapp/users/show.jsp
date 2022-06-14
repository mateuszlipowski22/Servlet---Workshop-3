<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 14.06.2022
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show</title>
</head>
<body>
<h3 class="m-0 font-weight-bold text-primary">User Details</h3>
<table style="width:100%" class="table">
  <tr>
    <td>Id</td>
    <td>${userShow.getId()}</td>
  </tr>
  <tr>
    <td>Name</td>
    <td>${userShow.getUserName()}</td>
  </tr>
  <tr>
    <td>Email</td>
    <td>${userShow.getEmail()}</td>
  </tr>
</table>
</body>
</html>
