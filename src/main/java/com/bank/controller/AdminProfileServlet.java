package com.bank.controller;

import java.io.IOException;

import com.bank.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminProfileServlet")
public class AdminProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("admin") == null) {

            response.sendRedirect("adminLogin.jsp");
            return;
        }


        Admin admin = (Admin) session.getAttribute("admin");

        request.setAttribute("admin", admin);


        request.getRequestDispatcher("adminProfile.jsp")
               .forward(request, response);

    }
}
