package com.bank.controller;

import java.io.IOException;

import com.bank.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        boolean status = dao.resetPassword(email, password);

        if (status) {

            response.sendRedirect("passwordResetSuccess.jsp");

        } else {

            response.sendRedirect("passwordResetFailed.jsp");

        }

    }
}