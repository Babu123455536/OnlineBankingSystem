package com.bank.controller;

import java.io.IOException;

import com.bank.dao.AccountDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        int accountId = Integer.parseInt(
                request.getParameter("accountId")
        );


        AccountDAO dao = new AccountDAO();


        boolean status = dao.deleteAccount(accountId);


        if(status){

            response.sendRedirect("ViewAccountsServlet");

        }else{

            response.getWriter().println("Delete Failed");

        }

    }
}
