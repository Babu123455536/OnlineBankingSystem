<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bank.model.Admin"%>

<%
Admin admin = (Admin) session.getAttribute("admin");

if(admin == null){
    response.sendRedirect("adminLogin.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">

        <span class="navbar-brand">
            <i class="bi bi-bank"></i>
            Online Banking System - Admin
        </span>

        <a href="AdminLogoutServlet" class="btn btn-danger">
            <i class="bi bi-box-arrow-right"></i>
            Logout
        </a>

    </div>
</nav>

<div class="container mt-4">

    <!-- Dashboard Cards -->
    <div class="row">

        <div class="col-md-3 mb-4">
            <div class="card bg-primary text-white shadow">
                <div class="card-body text-center">
                    <i class="bi bi-people-fill fs-1"></i>
                    <h5 class="mt-2">Total Users</h5>
                    <h2>${totalUsers}</h2>
                </div>
            </div>
        </div>

        <div class="col-md-3 mb-4">
            <div class="card bg-success text-white shadow">
                <div class="card-body text-center">
                    <i class="bi bi-bank fs-1"></i>
                    <h5 class="mt-2">Total Accounts</h5>
                    <h2>${totalAccounts}</h2>
                </div>
            </div>
        </div>

        <div class="col-md-3 mb-4">
            <div class="card bg-danger text-white shadow">
                <div class="card-body text-center">
                    <i class="bi bi-cash-stack fs-1"></i>
                    <h5 class="mt-2">Total Transactions</h5>
                    <h2>${totalTransactions}</h2>
                </div>
            </div>
        </div>

        <div class="col-md-3 mb-4">
            <div class="card bg-warning text-dark shadow">
                <div class="card-body text-center">
                    <i class="bi bi-wallet-fill fs-1"></i>
                    <h5 class="mt-2">Total Balance</h5>
                    <h2>₹ ${totalBalance}</h2>
                </div>
            </div>
        </div>

    </div>

    <!-- Menu Buttons -->
    <div class="row">

        <div class="col-md-3 mb-3">
            <a href="ViewUsersServlet" class="btn btn-primary w-100 p-3">
                <i class="bi bi-people-fill"></i><br>
                View Users
            </a>
        </div>

        <div class="col-md-3 mb-3">
            <a href="searchUser.jsp" class="btn btn-info w-100 p-3">
                <i class="bi bi-search"></i><br>
                Search User
            </a>
        </div>

        <div class="col-md-3 mb-3">
            <a href="ViewAccountsServlet" class="btn btn-success w-100 p-3">
                <i class="bi bi-bank"></i><br>
                View Accounts
            </a>
        </div>

        <div class="col-md-3 mb-3">
            <a href="ViewTransactionsServlet" class="btn btn-warning w-100 p-3">
                <i class="bi bi-clock-history"></i><br>
                View Transactions
            </a>
        </div>

        <div class="col-md-3 mb-3">
            <a href="AdminProfileServlet" class="btn btn-secondary w-100 p-3">
                <i class="bi bi-person-circle"></i><br>
                Admin Profile
            </a>
        </div>
<div class="col-md-3 mb-3">
    <a href="addBeneficiary.jsp" class="btn btn-primary w-100 p-3">
        <i class="bi bi-person-plus"></i><br>
        Add Beneficiary
    </a>
</div>
        <div class="col-md-3 mb-3">
            <a href="adminChangePassword.jsp" class="btn btn-dark w-100 p-3">
                <i class="bi bi-key-fill"></i><br>
                Change Password
            </a>
        </div>


        <div class="col-md-3 mb-3">
            <a href="AdminLogoutServlet" class="btn btn-danger w-100 p-3">
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