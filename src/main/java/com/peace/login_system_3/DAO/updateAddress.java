package com.peace.login_system_3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateAddress {

    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String name="system";
    String password="javasql135";
    Connection con;

    public void openConnection() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        con= DriverManager.getConnection(url,name,password);

    }

    public void changeAddress(String email,String Line_1,String Line_2,String Province,String District,String city,String zipCode) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql="UPDATE CUSTOMERADDRESS SET Line_1=?, Line_2=? ,Province=?,District=?,city=?,ZIP_CODE=? WHERE email=?";
        PreparedStatement pstmt=con.prepareStatement(sql);

        pstmt.setString(1,Line_1);
        pstmt.setString(2,Line_2);
        pstmt.setString(3,Province);
        pstmt.setString(4,District);
        pstmt.setString(5,city);
        pstmt.setString(6,zipCode);
        pstmt.setString(7,email);
        pstmt.executeQuery();

    }
}
