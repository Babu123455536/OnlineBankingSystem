package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Admin;
import com.bank.util.DBConnection;

public class AdminDAO {

    public Admin login(String username, String password) {

        Admin admin = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM admin WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                admin = new Admin();

                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
  }
    
    public boolean changePassword(int id, String password) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE admin SET password=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, password);
            ps.setInt(2, id);

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    } 
    
}
