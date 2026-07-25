package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AccountDAO;
import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int accountId = Integer.parseInt(request.getParameter("accountId"));

        double amount = Double.parseDouble(request.getParameter("amount"));

        AccountDAO dao = new AccountDAO();

        boolean status = dao.deposit(accountId, amount);

        if(status) {

            Transaction transaction = new Transaction();

            transaction.setAccountId(accountId);
            transaction.setTransactionType("Deposit");
            transaction.setAmount(amount);

            TransactionDAO transactionDAO = new TransactionDAO();

            transactionDAO.addTransaction(transaction);

            response.sendRedirect("ViewAccountServlet");

        }
         else {

            response.getWriter().println("Deposit Failed");

        }
    }
}