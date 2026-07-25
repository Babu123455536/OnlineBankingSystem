package com.bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bank.model.Account;
import com.bank.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllAccountsServlet")
public class ViewAllAccountsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Account> accounts = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM accounts";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Account account = new Account();

                account.setAccountId(rs.getInt("account_id"));
                account.setUserId(rs.getInt("user_id"));
                account.setAccountNumber(rs.getString("account_number"));
                account.setAccountType(rs.getString("account_type"));
                account.setBalance(rs.getDouble("balance"));

                accounts.add(account);
            }

            request.setAttribute("accounts", accounts);

            request.getRequestDispatcher("viewAccounts.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
