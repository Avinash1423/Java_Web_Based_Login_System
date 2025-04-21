package com.peace.login_system_3.DAO;

import java.sql.*;

public class updatePhoneNumber {


    public void changePhoneNumber(String loggedInEmail, String newPhoneNumber) throws Exception {

        Connection con=DbCon.getConnection();

        String sql = "UPDATE customerDetails SET phoneNumber=? WHERE email=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, newPhoneNumber);
        pstmt.setString(2, loggedInEmail);
        pstmt.executeQuery();

    }

    public boolean validatePhoneNumber(String newPhoneNumber) throws Exception {
        Connection con=DbCon.getConnection();
        String sql="SELECT * FROM customerDetails WHERE phoneNumber=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,newPhoneNumber);
        ResultSet rs=pstmt.executeQuery();

        if(rs.next())
            return false;
        else return true;

    }
    }


