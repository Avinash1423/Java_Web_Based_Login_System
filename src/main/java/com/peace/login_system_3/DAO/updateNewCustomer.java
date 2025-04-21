package com.peace.login_system_3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateNewCustomer {



    public void insertCredentials(String email,String Password) throws Exception {

        Connection con=DbCon.getConnection();
        String sql= "INSERT INTO Credentials VALUES(?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        pstmt.setString(2,Password);
        pstmt.executeQuery();

        pstmt.close();
        con.close();

    }

    public void insertDetails(String email ,String firstName,String lastName,String phoneNumber) throws Exception {
        Connection con=DbCon.getConnection();
        String sql="INSERT INTO customerDetails VALUES(?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        pstmt.setString(2,firstName);
        pstmt.setString(3,lastName);
        pstmt.setString(4,phoneNumber);
        pstmt.executeQuery();

        pstmt.close();
        con.close();

    }

     public void insertAddress(String email,String Line_1,String Line_2,String Province,String District,String City,String zipCode) throws Exception {
         Connection con=DbCon.getConnection();
        String sql="INSERT INTO customerAddress VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        pstmt.setString(2,Line_1);
        pstmt.setString(3,Line_2);
        pstmt.setString(4,Province);
        pstmt.setString(5,District);
        pstmt.setString(6,City);
        pstmt.setString(7,zipCode);
        pstmt.executeQuery();

         pstmt.close();
         con.close();

     }
}
