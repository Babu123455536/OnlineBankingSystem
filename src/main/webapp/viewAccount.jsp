<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Account Details</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>


<body class="bg-light">


<div class="container mt-5">


<div class="row justify-content-center">


<div class="col-md-6">


<div class="card shadow-lg">


<div class="card-header bg-primary text-white text-center">

<h3>
<i class="bi bi-credit-card"></i>
Account Details
</h3>

</div>


<div class="card-body">


<div class="mb-3">

<h5>
<i class="bi bi-hash"></i>
Account ID:
<span class="text-primary">
${accountId}
</span>
</h5>

</div>



<div class="mb-3">

<h5>
<i class="bi bi-bank"></i>
Account Type:
<span class="text-success">
${accountType}
</span>
</h5>

</div>



<div class="mb-3">

<h5>
<i class="bi bi-currency-rupee"></i>
Balance:
<span class="text-danger">
₹ ${balance}
</span>
</h5>

</div>



<a href="dashboard.jsp"
class="btn btn-secondary w-100">

<i class="bi bi-arrow-left"></i>
Back Dashboard

</a>


</div>


</div>


</div>


</div>


</div>


</body>
</html>