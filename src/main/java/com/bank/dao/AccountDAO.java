package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bank.model.Account;
import com.bank.util.DBConnection;

public class AccountDAO {

    public boolean createAccount(Account account) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO accounts(user_id, account_number, account_type, balance) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, account.getUserId());
            ps.setString(2, account.getAccountNumber());
            ps.setString(3, account.getAccountType());
            ps.setDouble(4, account.getBalance());

            int result = ps.executeUpdate();

            if (result > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean deposit(int accountId, double amount) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, accountId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                String transSql =
                        "INSERT INTO transactions(account_id, transaction_type, amount) VALUES(?,?,?)";

                PreparedStatement ps2 = con.prepareStatement(transSql);

                ps2.setInt(1, accountId);
                ps2.setString(2, "Deposit");
                ps2.setDouble(3, amount);

                ps2.executeUpdate();

                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public boolean withdraw(int accountId, double amount) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String checkSql = "SELECT balance FROM accounts WHERE account_id=?";

            PreparedStatement ps1 = con.prepareStatement(checkSql);
            ps1.setInt(1, accountId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    String updateSql =
                            "UPDATE accounts SET balance = balance - ? WHERE account_id=?";

                    PreparedStatement ps2 = con.prepareStatement(updateSql);

                    ps2.setDouble(1, amount);
                    ps2.setInt(2, accountId);

                    int rows = ps2.executeUpdate();

                    if (rows > 0) {

                        String transSql =
                                "INSERT INTO transactions(account_id, transaction_type, amount) VALUES(?,?,?)";

                        PreparedStatement ps3 = con.prepareStatement(transSql);

                        ps3.setInt(1, accountId);
                        ps3.setString(2, "Withdraw");
                        ps3.setDouble(3, amount);

                        ps3.executeUpdate();

                        status = true;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean transferMoney(int fromAccountId, int toAccountId, double amount) {

        boolean status = false;
        Connection con = null;

        try {

            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            String checkSql = "SELECT balance FROM accounts WHERE account_id=?";
            PreparedStatement ps1 = con.prepareStatement(checkSql);
            ps1.setInt(1, fromAccountId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    String deductSql =
                            "UPDATE accounts SET balance = balance - ? WHERE account_id=?";

                    PreparedStatement ps2 = con.prepareStatement(deductSql);
                    ps2.setDouble(1, amount);
                    ps2.setInt(2, fromAccountId);

                    int deduct = ps2.executeUpdate();

                    String addSql =
                            "UPDATE accounts SET balance = balance + ? WHERE account_id=?";

                    PreparedStatement ps3 = con.prepareStatement(addSql);
                    ps3.setDouble(1, amount);
                    ps3.setInt(2, toAccountId);

                    int add = ps3.executeUpdate();

                    if (deduct > 0 && add > 0) {
                        con.commit();
                        status = true;
                    } else {
                        con.rollback();
                    }
                }
            }

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }
    public boolean deleteAccount(int accountId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM accounts WHERE account_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountId);

            int result = ps.executeUpdate();

            if (result > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public ArrayList<Account> getAllAccounts() {

        ArrayList<Account> accounts = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM accounts";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Account acc = new Account();

                acc.setAccountId(rs.getInt("account_id"));
                acc.setUserId(rs.getInt("user_id"));
                acc.setAccountNumber(rs.getString("account_number"));
                acc.setAccountType(rs.getString("account_type"));
                acc.setBalance(rs.getDouble("balance"));

                accounts.add(acc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return accounts;
    }
    public Account searchAccount(String accountNumber) {

        Account account = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM accounts WHERE account_number=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, accountNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                account = new Account();

                account.setAccountId(rs.getInt("account_id"));
                account.setUserId(rs.getInt("user_id"));
                account.setAccountNumber(rs.getString("account_number"));
                account.setAccountType(rs.getString("account_type"));
                account.setBalance(rs.getDouble("balance"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }
    
    
}