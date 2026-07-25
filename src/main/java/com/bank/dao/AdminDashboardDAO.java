package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.util.DBConnection;

public class AdminDashboardDAO {

    public int getTotalUsers() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM users";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getTotalAccounts() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM accounts";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getTotalTransactions() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM transactions";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public double getTotalBalance() {

        double total = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT SUM(balance) FROM accounts";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}