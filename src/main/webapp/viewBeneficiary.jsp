<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.Beneficiary" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Beneficiaries</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<h2 class="text-center mb-4">
    My Beneficiaries
</h2>


<table class="table table-bordered table-striped">

<tr class="table-dark">

<th>ID</th>
<th>Name</th>
<th>Account Number</th>
<th>Bank Name</th>
<th>IFSC Code</th>
<th>Action</th>
</tr>


<%
List<Beneficiary> list =
(List<Beneficiary>) request.getAttribute("beneficiaries");


if(list != null && !list.isEmpty()) {

    for(Beneficiary b : list) {
%>

<tr>

<td><%= b.getBeneficiaryId() %></td>

<td><%= b.getBeneficiaryName() %></td>

<td><%= b.getAccountNumber() %></td>

<td><%= b.getBankName() %></td>

<td><%= b.getIfscCode() %></td>
<td>
    <a href="DeleteBeneficiaryServlet?beneficiaryId=<%= b.getBeneficiaryId() %>"
       class="btn btn-danger btn-sm"
       onclick="return confirm('Delete this beneficiary?');">
       
       Delete
       
    </a>
</td>
</tr>


<%
    }

}
else {
%>

<tr>
<td colspan="5" class="text-center">
No Beneficiaries Found
</td>
</tr>

<%
}
%>


</table>


<a href="addBeneficiary.jsp" class="btn btn-primary">
Add New Beneficiary
</a>


</div>

</body>
</html>