package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AccountDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int accountId = Integer.parseInt(request.getParameter("accountId"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        AccountDAO dao = new AccountDAO();

        boolean status = dao.withdraw(accountId, amount);

        if (status) {
            response.sendRedirect("ViewAccountServlet");
        } else {
            response.getWriter().println("<h3>Insufficient Balance</h3>");
        }
    }
}