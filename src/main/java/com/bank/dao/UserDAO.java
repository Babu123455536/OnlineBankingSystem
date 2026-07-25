package com.bank.dao;
import com.bank.dao.UserDAO;
import com.bank.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import com.bank.model.User;
import com.bank.util.DBConnection;
import java.sql.ResultSet;
public class UserDAO {

    public boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "insert into users(name,email,password,phone) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());


            int result = ps.executeUpdate();


            if(result > 0) {
                status = true;
            }


        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }
    
    public User loginUser(String email, String password) {

        User user = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	System.out.println("Email from DB: " + rs.getString("email"));
            	System.out.println("ID from DB: " + rs.getInt("id"));
                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
 
    public boolean deleteUser(int id) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM users WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }  
    
    public User searchUser(String email) {

        User user = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE email=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
            	System.out.println("Email from DB: " + rs.getString("email"));
            	System.out.println("ID from DB: " + rs.getInt("id"));
                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return user;
    } 
    public boolean changePassword(int id, String newPassword) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE users SET password=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPassword);
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
    
    public boolean resetPassword(String email, String newPassword) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE users SET password=? WHERE email=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setString(2, email);

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public boolean updateProfile(User user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE users SET name=?, phone=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setInt(3, user.getId());

            int result = ps.executeUpdate();

            if(result > 0){
                status = true;
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }  
    
    public ArrayList<User> getAllUsers() {

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    } 
}
