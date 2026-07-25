package com.bank.controller;

import java.io.IOException;

import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null){
            response.sendRedirect("login.jsp");
            return;
        }

        request.getRequestDispatcher("profile.jsp")
               .forward(request, response);
    }
}