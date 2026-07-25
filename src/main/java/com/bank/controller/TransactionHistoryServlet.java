package com.bank.controller;

import java.io.IOException;
import java.util.List;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TransactionHistoryServlet")
public class TransactionHistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        TransactionDAO dao = new TransactionDAO();

        List<Transaction> list = dao.getTransactions();

        request.setAttribute("transactions", list);

        request.getRequestDispatcher("transactionHistory.jsp")
               .forward(request, response);
    }
}
