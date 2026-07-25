
package com.bank.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.bank.dao.AccountDAO;
import com.bank.model.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewAccountsServlet")
public class ViewAccountsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        AccountDAO dao = new AccountDAO();

        ArrayList<Account> accounts = dao.getAllAccounts();

        request.setAttribute("accounts", accounts);

        request.getRequestDispatcher("viewAccounts.jsp")
               .forward(request, response);
    }
}