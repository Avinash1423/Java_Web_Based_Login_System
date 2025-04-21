package com.peace.login_system_3.DAO;

import java.sql.*;

public class newEmailValidate {


    public boolean validateEmail(String email) throws Exception {
        Connection con=DbCon.getConnection();
        String sql="SELECT * FROM customerDetails WHERE email=?";
        PreparedStatement pstmt= con.prepareStatement(sql);
        pstmt.setString(1,email);
        ResultSet rs= pstmt.executeQuery();

        if (rs.next())
            return false;
            else
                return true;

    }

    public boolean validatePhoneNumber(String phoneNumber) throws Exception {
        Connection con=DbCon.getConnection();
        String sql="SELECT * FROM customerDetails WHERE phoneNumber=?";
        PreparedStatement pstmt= con.prepareStatement(sql);
        pstmt.setString(1,phoneNumber);
        ResultSet rs= pstmt.executeQuery();
        if (rs.next())
            return false;
        else
            return true;

    }
}
