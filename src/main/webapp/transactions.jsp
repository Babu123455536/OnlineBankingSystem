<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bank.model.Transaction" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Transaction History</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>


<body class="bg-light">


<div class="container mt-5">


<div class="card shadow-lg">


<div class="card-header bg-dark text-white text-center">

<h3>
<i class="bi bi-clock-history"></i>
Transaction History
</h3>

</div>


<div class="card-body">


<table class="table table-bordered table-striped text-center">


<thead class="table-primary">

<tr>

<th>Transaction ID</th>

<th>Account ID</th>

<th>Type</th>

<th>Amount</th>

<th>Date</th>

</tr>

</thead>



<tbody>


<%
ArrayList<Transaction> list =
(ArrayList<Transaction>)request.getAttribute("transactions");


if(list != null)
{

for(Transaction t : list)
{
%>


<tr>

<td><%=t.getTransactionId()%></td>

<td><%=t.getAccountId()%></td>

<td>
<span class="badge bg-success">
<%=t.getTransactionType()%>
</span>
</td>

<td>
₹ <%=t.getAmount()%>
</td>

<td>

<%=t.getTransactionDate()%>
</td>


</tr>


<%
}
}
else
{
%>

<tr>

<td colspan="5">

No Transactions Found

</td>

</tr>

<%
}
%>


</tbody>


</table>



<a href="dashboard.jsp"
class="btn btn-secondary">

<i class="bi bi-arrow-left"></i>

Back Dashboard

</a>



</div>


</div>


</div>


</body>
</html>