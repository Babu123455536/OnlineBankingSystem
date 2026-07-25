package com.bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bank.model.User;
import com.bank.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewAllUsersServlet")
public class ViewAllUsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<User> users = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));

                users.add(user);
            }

            request.setAttribute("users", users);
            request.getRequestDispatcher("viewUsers.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}