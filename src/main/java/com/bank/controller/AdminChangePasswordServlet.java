
package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AdminDAO;
import com.bank.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminChangePasswordServlet")
public class AdminChangePasswordServlet extends HttpServlet {


private static final long serialVersionUID = 1L;


protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {


HttpSession session = request.getSession(false);


if(session == null || session.getAttribute("admin") == null){

response.sendRedirect("adminLogin.jsp");
return;

}


Admin admin = (Admin) session.getAttribute("admin");


String password = request.getParameter("password");


AdminDAO dao = new AdminDAO();


boolean status = dao.changePassword(admin.getId(), password);


if(status){

response.sendRedirect("AdminDashboardServlet");

}
else{

response.getWriter().println("Password Update Failed");

}


}

}