<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Beneficiary</title>

<style>
body{
    font-family: Arial;
    background:#f2f2f2;
}

.container{
    width:400px;
    margin:50px auto;
    background:white;
    padding:25px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

input{
    width:100%;
    padding:10px;
    margin:8px 0;
}

button{
    width:100%;
    padding:10px;
    background:#007bff;
    color:white;
    border:none;
    cursor:pointer;
}

button:hover{
    background:#0056b3;
}
</style>

</head>

<body>

<div class="container">

<h2>Add Beneficiary</h2>

<form action="AddBeneficiaryServlet" method="post">


<label>Beneficiary Name</label>
<input type="text" name="beneficiaryName" required>


<label>Account Number</label>
<input type="text" name="accountNumber" required>


<label>Bank Name</label>
<input type="text" name="bankName" required>


<label>IFSC Code</label>
<input type="text" name="ifscCode" required>


<button type="submit">
Add Beneficiary
</button>


</form>

</div>

</body>
</html>
