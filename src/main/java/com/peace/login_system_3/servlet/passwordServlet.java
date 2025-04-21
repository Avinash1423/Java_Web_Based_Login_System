package com.peace.login_system_3.servlet;

import com.peace.login_system_3.DAO.updateNewCustomer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name="passwordServlet" ,urlPatterns = "/passwordS")
public class passwordServlet  extends HttpServlet {
    String[] newDetails;
    String[] newAddress;
    String email;
    String firstName;
    String lastName;
    String phoneNumber;

    String Line_1;
    String Line_2;
    String Province;
    String District;
    String city;
    String zipCode;



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        updateNewCustomer update= new updateNewCustomer();
        String Password= request.getParameter("Password");
        String confirmPassword=request.getParameter("confirmPassword");


        if(Password.isEmpty()||confirmPassword.isEmpty()){

            request.setAttribute("emptyPasswordError","please fill both fields");
            getServletContext().getRequestDispatcher("/password.jsp").forward(request,response);

        }

        else if(!Password.equals(confirmPassword)){

            request.setAttribute("differentPasswordError","passwords do not match");
            getServletContext().getRequestDispatcher("/password.jsp").forward(request,response);
        }

        else{

            HttpSession session=request.getSession();
           newDetails= (String[])session.getAttribute("getnewDetails");
           newAddress= (String[])session.getAttribute("getnewAddress");
           email=(String)session.getAttribute("validEmail");
           phoneNumber=(String)session.getAttribute("validPhoneNumber");

            firstName=newDetails[0];
            lastName=newDetails[1];


            Line_1=newAddress[0];
            Line_2=newAddress[1];
            Province=newAddress[2];
            District=newAddress[3];
            city=newAddress[4];
            zipCode=newAddress[5];

           String hashedPassword= BCrypt.hashpw(Password,BCrypt.gensalt(12));
            try {
                update.insertCredentials(email,hashedPassword);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                update.insertDetails(email,firstName,lastName,phoneNumber);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                update.insertAddress(email,Line_1,Line_2,Province,District,city,zipCode);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
        }


    }
}
