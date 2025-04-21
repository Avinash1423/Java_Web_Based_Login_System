package com.peace.login_system_3.DAO;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.Calendar;

public class accountDetails {




    public  String[] getCustomerDetails(String validEmail) throws Exception {

        Connection con=DbCon.getConnection();

        String sql="SELECT * FROM CUSTOMERDETAILS  WHERE email=?";
        PreparedStatement pstmt= con.prepareStatement(sql);
        pstmt.setString(1,validEmail);
        ResultSet rs= pstmt.executeQuery();
        rs.next();
        String email= rs.getString("email");
        String firstName=rs.getString("firstName");
        String lastName=rs.getString("lastName");
        String PhoneNumber=rs.getString("phoneNumber");


       String[] details = new String[]{email,firstName,lastName,PhoneNumber};
        rs.close();
        pstmt.close();
         con.close();


       return details;

    }

    public String[] getCustomerAddress(String correctEmail) throws Exception {

        Connection con=DbCon.getConnection();

        String sql="SELECT * FROM customerAddress WHERE email=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,correctEmail);
        ResultSet rs= pstmt.executeQuery();
        rs.next();

        String Line1=rs.getString(2);
        String Line2=rs.getString(3);
        String Province=rs.getString(4);
        String District=rs.getString(5);
        String City=rs.getString(6);
        String zipCode=rs.getString(7);

        String[] Address=new String[]{Line1,Line2,Province,District,City,zipCode};


        return Address;

    }
}
