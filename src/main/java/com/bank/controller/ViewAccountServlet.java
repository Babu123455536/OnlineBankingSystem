package com.bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.User;
import com.bank.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewAccountServlet")
public class ViewAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            User user = (User) session.getAttribute("user");

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM accounts WHERE user_id=?";

            System.out.println("Logged-in User ID: " + user.getId());
            
            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setInt(1, user.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

            	
            	System.out.println("Account ID = " + rs.getInt("account_id"));
            	System.out.println("Account Type = " + rs.getString("account_type"));
            	System.out.println("Balance = " + rs.getDouble("balance"));
                request.setAttribute("accountId", rs.getInt("account_id"));
                request.setAttribute("accountType", rs.getString("account_type"));
                request.setAttribute("balance", rs.getDouble("balance"));

                request.getRequestDispatcher("viewAccount.jsp").forward(request, response);

            } else {

                response.getWriter().println("<h3>No Account Found!</h3>");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}