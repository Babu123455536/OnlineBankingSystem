
package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AccountDAO;
import com.bank.model.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchAccountServlet")
public class SearchAccountServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accountNumber = request.getParameter("accountNumber");

        AccountDAO dao = new AccountDAO();

        Account account = dao.searchAccount(accountNumber);

        if (account != null) {

            request.setAttribute("account", account);

            request.getRequestDispatcher("searchResult.jsp")
                   .forward(request, response);

        } else {

            response.sendRedirect("accountNotFound.jsp");

        }

    }
}