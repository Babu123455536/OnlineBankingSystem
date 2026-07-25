package com.bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jakarta.servlet.http.HttpServlet;
import com.bank.model.Transaction;
import com.bank.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewTransactionsServlet")
public class ViewTransactionsServlet extends HttpServlet {

	
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Transaction> list = new ArrayList<>();

        try {

        	HttpSession session = request.getSession(false);

        	if (session == null || 
        	   (session.getAttribute("user") == null && 
        	    session.getAttribute("admin") == null)) {

        	    response.sendRedirect("login.jsp");
        	    return;
        	}
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM transactions ORDER BY transaction_date DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Transaction t = new Transaction();

                t.setTransactionId(rs.getInt("transaction_id"));
                t.setAccountId(rs.getInt("account_id"));
                t.setTransactionType(rs.getString("transaction_type"));
                t.setAmount(rs.getDouble("amount"));
                t.setTransactionDate(rs.getTimestamp("transaction_date"));

                list.add(t);
            }

            request.setAttribute("transactions", list);
            request.getRequestDispatcher("transactions.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}