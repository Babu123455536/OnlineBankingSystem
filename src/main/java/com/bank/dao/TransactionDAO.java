package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

import java.util.List;

import com.bank.model.Transaction;
import com.bank.util.DBConnection;

public class TransactionDAO {

    public boolean addTransaction(Transaction transaction) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO transactions(account_id, transaction_type, amount) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, transaction.getAccountId());
            ps.setString(2, transaction.getTransactionType());
            ps.setDouble(3, transaction.getAmount());

            int result = ps.executeUpdate();

            if (result > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public List<Transaction> getTransactions() {

        List<Transaction> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from transactions";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Transaction t = new Transaction();

                t.setTransactionId(rs.getInt("transaction_id"));
                t.setAccountId(rs.getInt("account_id"));
                t.setTransactionType(rs.getString("transaction_type"));
                t.setAmount(rs.getDouble("amount"));
                t.setTransactionDate(
                    rs.getTimestamp("transaction_date")
                );

                list.add(t);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    } 
    
    public ArrayList<Transaction> getAllTransactions() {

        ArrayList<Transaction> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM transactions";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Transaction t = new Transaction();

                t.setTransactionId(rs.getInt("transaction_id"));
                t.setAccountId(rs.getInt("account_id"));
                t.setTransactionType(rs.getString("transaction_type"));
                t.setAmount(rs.getDouble("amount"));
                t.setTransactionDate(rs.getTimestamp("transaction_date"));

                list.add(t);
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return list;
    }
    public ArrayList<Transaction> getTransactionsByUser(int userId) {

        ArrayList<Transaction> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            		"SELECT t.* FROM transactions t "
            		+ "JOIN accounts a ON t.account_id = a.account_id "
            		+ "WHERE a.user_id=? "
            		+ "ORDER BY t.transaction_date DESC";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);


            ResultSet rs = ps.executeQuery();


            while(rs.next()) {

                Transaction t = new Transaction();

                t.setTransactionId(
                    rs.getInt("transaction_id")
                );

                t.setAccountId(
                    rs.getInt("account_id")
                );

                t.setTransactionType(
                    rs.getString("transaction_type")
                );

                t.setAmount(
                    rs.getDouble("amount")
                );

                t.setTransactionDate(
                    rs.getTimestamp("transaction_date")
                );


                list.add(t);

            }


        } catch(Exception e) {

            e.printStackTrace();

        }


        return list;
    }  
    
}