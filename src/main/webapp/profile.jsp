<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.bank.model.User"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>User Profile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>


<body class="bg-light">


<div class="container mt-5">


<div class="row justify-content-center">


<div class="col-md-5">


<div class="card shadow-lg">


<div class="card-header bg-primary text-white text-center">

<h3>
<i class="bi bi-person-circle"></i>
My Profile
</h3>

</div>



<div class="card-body">


<h5>
<i class="bi bi-person-fill"></i>
Name :
${user.name}
</h5>


<hr>


<h5>
<i class="bi bi-envelope-fill"></i>
Email :
${user.email}
</h5>


<hr>


<h5>
<i class="bi bi-telephone-fill"></i>
Phone :
${user.phone}
</h5>


<hr>


<a href="dashboard.jsp"
class="btn btn-primary w-100">

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