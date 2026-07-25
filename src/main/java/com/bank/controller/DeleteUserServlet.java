package com.bank.controller;

import java.io.IOException;

import com.bank.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        UserDAO dao = new UserDAO();

        boolean status = dao.deleteUser(id);

        if(status) {

            response.sendRedirect("ViewAllUsersServlet");

        } else {

            response.getWriter().println("Delete Failed");

        }
    }
}
