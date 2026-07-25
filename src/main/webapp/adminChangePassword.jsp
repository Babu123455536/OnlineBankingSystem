<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Admin Change Password</title>

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
Admin Change Password
</h3>

</div>



<div class="card-body">


<form action="AdminChangePasswordServlet" method="post">



<div class="mb-3">

<label class="form-label">
Current Password
</label>

<input type="password"
name="oldPassword"
class="form-control"
required>

</div>



<div class="mb-3">

<label class="form-label">
New Password
</label>

<input type="password"
name="newPassword"
class="form-control"
required>

</div>



<div class="mb-3">

<label class="form-label">
Confirm Password
</label>

<input type="password"
name="confirmPassword"
class="form-control"
required>

</div>



<button class="btn btn-dark w-100">

<i class="bi bi-key-fill"></i>

Update Password

</button>



<a href="AdminDashboardServlet"
class="btn btn-primary w-100 mt-2">

<i class="bi bi-arrow-left"></i>

Back Dashboard

</a>



</form>


</div>


</div>


</div>


</div>


</div>


</body>
</html>