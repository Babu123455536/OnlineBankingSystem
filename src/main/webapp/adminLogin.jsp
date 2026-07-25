<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Admin Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-secondary">


<div class="container mt-5">


<div class="row justify-content-center">


<div class="col-md-5">


<div class="card shadow-lg">


<div class="card-header bg-dark text-white text-center">

<h3>
<i class="bi bi-shield-lock-fill"></i>
Admin Login
</h3>

</div>


<div class="card-body">


<form action="AdminLoginServlet" method="post">


<div class="mb-3">

<label>Username</label>

<input type="text"
name="username"
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


<button class="btn btn-dark w-100">

<i class="bi bi-box-arrow-in-right"></i>
Admin Login

</button>


</form>


<hr>


<a href="login.jsp"
class="btn btn-primary w-100">

<i class="bi bi-person"></i>
User Login

</a>


</div>

</div>


</div>


</div>


</div>


</body>
</html>