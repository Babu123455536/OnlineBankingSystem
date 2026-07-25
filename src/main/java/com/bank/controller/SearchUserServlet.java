package com.bank.controller;

import java.io.IOException;

import com.bank.dao.UserDAO;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");

        UserDAO dao = new UserDAO();

        User user = dao.searchUser(email);

        if (user != null) {

            request.setAttribute("user", user);

            request.getRequestDispatcher("searchUserResult.jsp")
                   .forward(request, response);

        } else {

            response.sendRedirect("userNotFound.jsp");

        }

    }
}