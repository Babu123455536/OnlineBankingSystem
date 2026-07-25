<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Password Reset Failed</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card shadow-lg border-danger">

<div class="card-header bg-danger text-white text-center">

<h3>
<i class="bi bi-x-circle-fill"></i>
Password Reset Failed
</h3>

</div>

<div class="card-body text-center">

<i class="bi bi-exclamation-triangle-fill text-danger"
style="font-size:70px;"></i>

<h4 class="mt-3 text-danger">
Reset Failed!
</h4>

<p class="text-muted">
Email not found or password could not be updated.
</p>

<a href="forgotPassword.jsp"
class="btn btn-danger w-100">

<i class="bi bi-arrow-repeat"></i>

Try Again

</a>

<a href="login.jsp"
class="btn btn-secondary w-100 mt-2">

<i class="bi bi-house"></i>

Back to Login

</a>

</div>

</div>

</div>

</div>

</div>

</body>
</html>