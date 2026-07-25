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

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null){

            response.sendRedirect("login.jsp");
            return;
        }


        User user = (User) session.getAttribute("user");


        String password = request.getParameter("password");


        UserDAO dao = new UserDAO();


        boolean status = dao.changePassword(user.getId(), password);


        if(status){

            response.getWriter().println(
                "<h2>Password Changed Successfully</h2>"
            );

        }else{

            response.getWriter().println(
                "<h2>Password Change Failed</h2>"
            );
        }

    }
}