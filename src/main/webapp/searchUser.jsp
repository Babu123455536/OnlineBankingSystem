<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search User</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card shadow-lg">

<div class="card-header bg-info text-white text-center">

<h3>
<i class="bi bi-search"></i>
Search User
</h3>

</div>

<div class="card-body">

<form action="SearchUserServlet" method="post">

<div class="mb-3">

<label>Email</label>

<input type="email"
name="email"
class="form-control"
required>

</div>

<button class="btn btn-info w-100">

<i class="bi bi-search"></i>

Search

</button>

<a href="adminDashboard.jsp"
class="btn btn-secondary w-100 mt-2">

Back

</a>

</form>

</div>

</div>

</div>

</div>

</div>

</body>
</html>