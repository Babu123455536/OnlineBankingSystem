package com.bank.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Beneficiary;
import com.bank.util.DBConnection;

public class BeneficiaryDAO {


    // Add Beneficiary
    public boolean addBeneficiary(Beneficiary beneficiary) {

        boolean status = false;

        String sql = "INSERT INTO beneficiaries(user_id, beneficiary_name, account_number, bank_name, ifsc_code) VALUES(?,?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, beneficiary.getUserId());
            ps.setString(2, beneficiary.getBeneficiaryName());
            ps.setString(3, beneficiary.getAccountNumber());
            ps.setString(4, beneficiary.getBankName());
            ps.setString(5, beneficiary.getIfscCode());

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }



    // View Beneficiaries
    public List<Beneficiary> getBeneficiaries(int userId) {

        List<Beneficiary> list = new ArrayList<>();

        String sql = "SELECT * FROM beneficiaries WHERE user_id=?";

        try(Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Beneficiary b = new Beneficiary();

                b.setBeneficiaryId(rs.getInt("beneficiary_id"));
                b.setUserId(rs.getInt("user_id"));
                b.setBeneficiaryName(rs.getString("beneficiary_name"));
                b.setAccountNumber(rs.getString("account_number"));
                b.setBankName(rs.getString("bank_name"));
                b.setIfscCode(rs.getString("ifsc_code"));

                list.add(b);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public boolean deleteBeneficiary(int beneficiaryId) {

        boolean status = false;

        String sql = "DELETE FROM beneficiaries WHERE beneficiary_id=?";

        try(Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, beneficiaryId);

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
