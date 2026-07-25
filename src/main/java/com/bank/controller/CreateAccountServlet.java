package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AccountDAO;
import com.bank.model.Account;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String accountNumber = request.getParameter("accountNumber");
        String accountType = request.getParameter("accountType");
        double balance = Double.parseDouble(request.getParameter("balance"));

        Account account = new Account();

        account.setUserId(user.getId());
        account.setAccountNumber(accountNumber);
        account.setAccountType(accountType);
        account.setBalance(balance);

        AccountDAO dao = new AccountDAO();

        boolean status = dao.createAccount(account);

        if (status) {
            response.sendRedirect("dashboard.jsp");
        } else {
            response.getWriter().println("<h2>Account Creation Failed</h2>");
        }
    }
}
