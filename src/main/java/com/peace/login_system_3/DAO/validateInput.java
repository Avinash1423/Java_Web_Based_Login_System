package com.peace.login_system_3.DAO;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class validateInput {



        public  boolean validate(String email) throws Exception {
            Connection con=DbCon.getConnection();
            String check="SELECT COUNT(*) FROM Credentials WHERE email=?";
            PreparedStatement pstmt=con.prepareStatement(check);
            pstmt.setString(1,email);
            ResultSet rs=pstmt.executeQuery();

            if(rs.next()) {
                int count = rs.getInt(1);
                if(count>0) {

                    return true;
                }
                else {

                    return false;
                }
            }

            return false;


        }

    public  boolean validateCredentials(String email, String password) throws Exception {

        Connection con=DbCon.getConnection();
            String check="Select * FROM Credentials WHERE email=?";
            PreparedStatement pstmt=con.prepareStatement(check);
            pstmt.setString(1,email);
            ResultSet rs= pstmt.executeQuery();
            rs.next();
            if(rs.getString("email").equals(email)) {

                String hashedPassword=rs.getString("password");

                if(BCrypt.checkpw(password,hashedPassword))
                    return true;
                else return false;

            }
//               if(rs.getString("password").equals(password)){
//                    return true;
//                }
//            }
//            else {
//                return false;}

       // con.close();
       // rs.close();
       // pstmt.close();
            return false;

    }

}
