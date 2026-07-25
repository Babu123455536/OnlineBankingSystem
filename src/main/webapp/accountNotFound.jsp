<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Account Not Found</title>

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

Account Not Found

</h3>

</div>

<div class="card-body text-center">

<h4 class="text-danger">

No Account Found!

</h4>

<p>Please enter a valid account number.</p>

<a href="searchAccount.jsp"
class="btn btn-danger">

<i class="bi bi-arrow-repeat"></i>

Try Again

</a>

<a href="dashboard.jsp"
class="btn btn-secondary">

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