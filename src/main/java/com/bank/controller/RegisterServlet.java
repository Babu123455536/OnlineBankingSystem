package com.bank.controller;

import java.io.IOException;

import com.bank.dao.UserDAO;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        UserDAO dao = new UserDAO();

        boolean status = dao.registerUser(user);

        if (status) {
        	if(status) {

        	    response.sendRedirect("registerSuccess.jsp");

        	}
        	else {

        	    response.getWriter().println("Registration Failed");

        	}
        } else {
        	response.sendRedirect("registerFailed.jsp");
        }
    }
}
