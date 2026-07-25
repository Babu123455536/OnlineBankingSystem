<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.bank.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Users</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body{
    font-family: Arial, sans-serif;
    background:#f4f4f4;
}

.container{
    width:90%;
    margin:auto;
    margin-top:30px;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
}

th,td{
    border:1px solid #ddd;
    padding:10px;
    text-align:center;
}

th{
    background:#007bff;
    color:white;
}

a{
    text-decoration:none;
}
</style>

</head>
<body>

<div class="container">

<h2>All Registered Users</h2>

<table>

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Action</th>
</tr>

<%
ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");

if(users != null){

    for(User user : users){
%>

<tr>

<td><%= user.getId() %></td>
<td><%= user.getName() %></td>
<td><%= user.getEmail() %></td>
<td><%= user.getPhone() %></td>
<td>
<a href="DeleteUserServlet?id=<%= user.getId() %>" 
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

<br>

<a href="adminDashboard.jsp">Back to Admin Dashboard</a>

</div>

</body>
</html>
