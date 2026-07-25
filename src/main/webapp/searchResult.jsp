<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.bank.model.Account"%>

<%
Account account = (Account) request.getAttribute("account");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Search Result</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow-lg">

<div class="card-header bg-success text-white text-center">

<h3>

<i class="bi bi-search"></i>

Account Details

</h3>

</div>

<div class="card-body">

<table class="table table-bordered">

<tr>

<th>Account ID</th>

<td><%=account.getAccountId()%></td>

</tr>

<tr>

<th>Account Number</th>

<td><%=account.getAccountNumber()%></td>

</tr>

<tr>

<th>Account Type</th>

<td><%=account.getAccountType()%></td>

</tr>

<tr>

<th>Balance</th>

<td>₹ <%=account.getBalance()%></td>

</tr>

</table>

<a href="searchAccount.jsp"
class="btn btn-primary">

<i class="bi bi-search"></i>

Search Again

</a>

<a href="dashboard.jsp"
class="btn btn-secondary">

<i class="bi bi-arrow-left"></i>

Dashboard

</a>

</div>

</div>

</div>

</div>

</div>

</body>
</html>