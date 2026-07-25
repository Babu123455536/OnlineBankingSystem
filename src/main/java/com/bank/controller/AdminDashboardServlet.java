package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AdminDashboardDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        AdminDashboardDAO dao = new AdminDashboardDAO();

        int users = dao.getTotalUsers();
        int accounts = dao.getTotalAccounts();
        int transactions = dao.getTotalTransactions();
        double balance = dao.getTotalBalance();

        request.setAttribute("totalUsers", users);
        request.setAttribute("totalAccounts", accounts);
        request.setAttribute("totalTransactions", transactions);
        request.setAttribute("totalBalance", balance);

        request.getRequestDispatcher("adminDashboard.jsp")
               .forward(request, response);
    }
}