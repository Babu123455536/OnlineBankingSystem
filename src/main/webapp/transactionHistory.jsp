<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.Transaction" %>

<!DOCTYPE html>
<html>
<head>
<title>Transaction History</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<h2 class="text-center mb-4">
Transaction History
</h2>

<table class="table table-bordered table-striped">

<tr>
<th>Transaction ID</th>
<th>Account ID</th>
<th>Type</th>
<th>Amount</th>
<th>Date</th>
</tr>

<%
List<Transaction> list =
(List<Transaction>)request.getAttribute("transactions");

if(list != null){

for(Transaction t : list){
%>

<tr>
<td><%=t.getTransactionId()%></td>
<td><%=t.getAccountId()%></td>
<td><%=t.getTransactionType()%></td>
<td><%=t.getAmount()%></td>
<td><%=t.getTransactionDate()%></td>
</tr>

<%
}
}
%>

</table>

<a href="dashboard.jsp" class="btn btn-primary">
Back Dashboard
</a>

</div>

</body>
</html>