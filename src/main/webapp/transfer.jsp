<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bank.model.Beneficiary"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Transfer Money</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>


<body class="bg-light">


<div class="container mt-5">


<div class="row justify-content-center">


<div class="col-md-5">


<div class="card shadow-lg">


<div class="card-header bg-warning text-dark text-center">

<h3>
<i class="bi bi-arrow-left-right"></i>
Transfer Money
</h3>

</div>



<div class="card-body">


<form action="TransferServlet" method="post">


<div class="mb-3">

<label class="form-label">
From Account ID
</label>

<input type="number"
name="fromAccountId"
class="form-control"
required>

</div>



<div class="mb-3">

<label class="form-label">
To Account ID
</label>

<input type="number"
name="toAccountId"
class="form-control"
required>

</div>



<div class="mb-3">

<label class="form-label">
Amount
</label>

<label>Select Beneficiary</label>

<select name="accountNumber" class="form-control" required>

    <option value="">-- Select Beneficiary --</option>

    <%
    List<Beneficiary> list =
        (List<Beneficiary>) request.getAttribute("beneficiaries");

    if(list != null){
        for(Beneficiary b : list){
    %>

    <option value="<%= b.getAccountNumber() %>">
        <%= b.getBeneficiaryName() %> -
        <%= b.getAccountNumber() %>
    </option>

    <%
        }
    }
    %>

</select>

</div>



<button class="btn btn-warning w-100">

<i class="bi bi-send-fill"></i>

Transfer Money

</button>



<a href="dashboard.jsp"
class="btn btn-secondary w-100 mt-2">

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