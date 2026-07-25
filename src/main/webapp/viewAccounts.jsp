<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.bank.model.Account"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Accounts</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
table{
    border-collapse:collapse;
    width:100%;
}
th,td{
    border:1px solid black;
    padding:8px;
    text-align:center;
}
th{
    background-color:#4CAF50;
    color:white;
}
</style>
</head>
<body>

<h2>All Bank Accounts</h2>

<table>

<tr>
    <th>Account ID</th>
    <th>User ID</th>
    <th>Account Number</th>
    <th>Account Type</th>
    <th>Balance</th>
    <th>Action</th>
</tr>

<%
ArrayList<Account> accounts =
(ArrayList<Account>)request.getAttribute("accounts");

if(accounts != null){
    for(Account acc : accounts){
%>

<tr>
    <td><%= acc.getAccountId() %></td>
    <td><%= acc.getUserId() %></td>
    <td><%= acc.getAccountNumber() %></td>
    <td><%= acc.getAccountType() %></td>
    <td><%= acc.getBalance() %></td>
    

<td>
<a href="DeleteAccountServlet?accountId=<%= acc.getAccountId() %>"
   class="btn btn-danger btn-sm">
   Delete
</a>
</td>
</tr>

<%
    }
}
%>

</table>

<br><br>

<a href="adminDashboard.jsp">Back to Admin Dashboard</a>

</body>
</html>
