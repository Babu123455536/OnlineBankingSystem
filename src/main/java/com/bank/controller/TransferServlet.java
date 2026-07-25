package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AccountDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int fromAccountId =
                Integer.parseInt(request.getParameter("fromAccountId"));

        int toAccountId =
                Integer.parseInt(request.getParameter("toAccountId"));

        double amount =
                Double.parseDouble(request.getParameter("amount"));

        AccountDAO dao = new AccountDAO();

        boolean status =
                dao.transferMoney(fromAccountId, toAccountId, amount);

        if (status) {

            response.sendRedirect("ViewAccountServlet");

        } else {

            response.getWriter().println("<h3>Transfer Failed!</h3>");

        }
    }
}