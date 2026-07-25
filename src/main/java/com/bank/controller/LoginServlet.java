package com.bank.controller;

import java.io.IOException;

import com.bank.dao.UserDAO;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Entered Email: " + email);
        System.out.println("Entered Password: " + password);

        UserDAO dao = new UserDAO();
        User user = dao.loginUser(email, password);

        if (user != null) {

            HttpSession oldSession = request.getSession(false);

            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            System.out.println("Login User ID: " + user.getId());

            response.sendRedirect("dashboard.jsp");

        } else {

            response.getWriter().println("<h2>Invalid Email or Password</h2>");

        }
    }
}
