<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>User Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-dark">


<div class="container mt-5">

<div class="row justify-content-center">


<div class="col-md-5">


<div class="card shadow-lg">


<div class="card-header bg-primary text-white text-center">

<h3>
<i class="bi bi-person-circle"></i>
User Login
</h3>

</div>


<div class="card-body">


<form action="LoginServlet" method="post">


<div class="mb-3">

<label>Email</label>

<input type="email"
name="email"
class="form-control"
required>

</div>


<div class="mb-3">

<label>Password</label>

<input type="password"
name="password"
class="form-control"
required>

</div>


<button class="btn btn-primary w-100">

<i class="bi bi-box-arrow-in-right"></i>
Login

</button>


</form>


<hr>


<a href="register.jsp"
class="btn btn-success w-100">

<i class="bi bi-person-plus"></i>
Create New Account

</a>


</div>

</div>


</div>

</div>

</div>


</body>
</html>