<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.bank.model.User"%>

<%
User user = (User)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search User Result</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow-lg">

<div class="card-header bg-info text-white text-center">

<h3>
<i class="bi bi-person-check-fill"></i>
User Details
</h3>

</div>

<div class="card-body">

<table class="table table-bordered">

<tr>
<th>User ID</th>
<td><%=user.getId()%></td>
</tr>

<tr>
<th>Name</th>
<td><%=user.getName()%></td>
</tr>

<tr>
<th>Email</th>
<td><%=user.getEmail()%></td>
</tr>

<tr>
<th>Phone</th>
<td><%=user.getPhone()%></td>
</tr>

</table>

<a href="searchUser.jsp" class="btn btn-info">
<i class="bi bi-search"></i>
Search Again
</a>

<a href="adminDashboard.jsp" class="btn btn-secondary">
<i class="bi bi-house"></i>
Dashboard
</a>

</div>

</div>

</div>

</div>

</div>

</body>
</html>