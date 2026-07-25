package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AdminDAO;
import com.bank.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDAO dao = new AdminDAO();

        Admin admin = dao.login(username, password);

        if (admin != null) {

            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);

            response.sendRedirect("AdminDashboardServlet");

        } else {

            response.getWriter().println("<h2>Invalid Username or Password</h2>");

        }
    }
}