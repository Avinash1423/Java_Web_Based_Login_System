package com.peace.login_system_3.DAO;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class Delete {




    public boolean confirmPassword(String email,String password1) throws Exception {
        System.out.println(email+"  "+ password1);
        System.out.println("Inside confirmPassword1111111");//works
        Connection con=DbCon.getConnection();
        System.out.println("Inside confirmPassword22222222");//worksss
        String sql="SELECT password FROM credentials WHERE email=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        ResultSet rs=pstmt.executeQuery();
        System.out.println("Inside confirmPassword3333333333333");//does not work
        rs.next();
        System.out.println("Moved to the first line");
        String hashedPassword = rs.getString("password");
        System.out.println("in password col");
        if(BCrypt.checkpw(password1, hashedPassword)) {
            return true;
        }
        else
            return false;

    }

    public void deleteCredentials(String email) throws Exception {

        Connection con=DbCon.getConnection();
        String sql="DELETE  FROM credentials WHERE email=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        pstmt.executeQuery();

    }

    public void deleteAddress(String email) throws Exception {

        Connection con=DbCon.getConnection();
        String sql="DELETE  FROM customerAddress WHERE email=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        pstmt.executeQuery();
    }

    public void deleteDetails(String email) throws Exception {

        Connection con=DbCon.getConnection();
        String sql="DELETE  FROM customerDetails WHERE email=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        pstmt.executeQuery();

    }
}
