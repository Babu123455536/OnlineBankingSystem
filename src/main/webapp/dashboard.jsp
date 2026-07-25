<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.bank.model.User"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);

User user = (User) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">

        <span class="navbar-brand">
            <i class="bi bi-bank"></i>
            Online Banking System
        </span>

        <span class="text-white">
            Welcome, <%= user.getName() %>
        </span>

    </div>
</nav>

<div class="container mt-5">

    <div class="row">

        <div class="col-md-4 mb-3">
            <a href="createAccount.jsp" class="btn btn-success w-100 p-3">
                <i class="bi bi-person-plus-fill"></i><br>
                Create Account
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="ViewAccountServlet" class="btn btn-primary w-100 p-3">
                <i class="bi bi-bank"></i><br>
                View Account
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="searchAccount.jsp" class="btn btn-outline-success w-100 p-3">
                <i class="bi bi-search"></i><br>
                Search Account
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="deposit.jsp" class="btn btn-info w-100 p-3">
                <i class="bi bi-cash-coin"></i><br>
                Deposit Money
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="withdraw.jsp" class="btn btn-warning w-100 p-3">
                <i class="bi bi-wallet2"></i><br>
                Withdraw Money
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="transfer.jsp" class="btn btn-secondary w-100 p-3">
                <i class="bi bi-arrow-left-right"></i><br>
                Transfer Money
            </a>
        </div>
<div class="col-md-3 mb-3">
    <a href="addBeneficiary.jsp" class="btn btn-primary w-100 p-3">
        <i class="bi bi-person-plus"></i><br>
        Add Beneficiary
    </a>
</div>


<div class="col-md-3 mb-3">
    <a href="ViewBeneficiaryServlet" class="btn btn-success w-100 p-3">
        <i class="bi bi-people-fill"></i><br>
        View Beneficiaries
    </a>
</div>
       
        <div class="col-md-4 mb-3">
            <a href="ViewTransactionsServlet" class="btn btn-dark w-100 p-3">
                <i class="bi bi-clock-history"></i><br>
                Transaction History
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="DownloadStatementServlet" class="btn btn-danger w-100 p-3">
                <i class="bi bi-file-earmark-pdf"></i><br>
                Download Statement
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="ProfileServlet" class="btn btn-primary w-100 p-3">
                <i class="bi bi-person-circle"></i><br>
                My Profile
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="changePassword.jsp" class="btn btn-warning w-100 p-3">
                <i class="bi bi-key-fill"></i><br>
                Change Password
            </a>
        </div>

        <div class="col-md-4 mb-3">
            <a href="LogoutServlet" class="btn btn-danger w-100 p-3">
                <i class="bi bi-box-arrow-right"></i><br>
                Logout
            </a>
        </div>

    </div>

</div>

<footer class="bg-dark text-white text-center p-3 mt-5">
    Online Banking System © 2026
</footer>

</body>
</html>