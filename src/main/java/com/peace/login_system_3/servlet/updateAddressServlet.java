package com.peace.login_system_3.servlet;

import com.peace.login_system_3.DAO.accountDetails;
import com.peace.login_system_3.DAO.updateAddress;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="updateAddressServlet",urlPatterns = "/updateAddressServlet")
public class updateAddressServlet extends HttpServlet {
    String Line_1;
    String Line_2;
    String Province;
    String District;
    String City;
    String zipCode;
    String loggedInEmail;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] oldAddress;
        String[] newAddress;
        HttpSession session=request.getSession();

        loggedInEmail=(String)session.getAttribute("loggedInEmail");

        Line_1=request.getParameter("Line_1");
        Line_2=request.getParameter("Line_2");
        Province=request.getParameter("Province");
        District=request.getParameter("District");
        City=request.getParameter("City");
        zipCode=request.getParameter("zipCode");

        if(Line_1.isEmpty()||Province.isEmpty() ||District.isEmpty()||City.isEmpty()||zipCode.isEmpty()){
            request.setAttribute("incompleteAddressError","Please fill all required fields.");
            getServletContext().getRequestDispatcher("/updateAddress.jsp").forward(request,response);
        }
         accountDetails details=new accountDetails();
        try {
            oldAddress=details.getCustomerAddress(loggedInEmail);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        updateAddress change=new updateAddress();
        try {
            change.changeAddress(loggedInEmail,Line_1,Line_2,Province,District,City,zipCode);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            newAddress=details.getCustomerAddress(loggedInEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("Add_change","Your Address has changed from:");
        session.setAttribute("Old_Line_1",oldAddress[0]+",");
        session.setAttribute("Old_Line_2",oldAddress[1]+",");
        session.setAttribute("Old_Province",oldAddress[2]+",");
        session.setAttribute("Old_District",oldAddress[3]+",");
        session.setAttribute("Old_City",oldAddress[4]+",");
        session.setAttribute("Old_Zipcode",oldAddress[5]+".");
        
        session.setAttribute("to","to");

        
        session.setAttribute("New_Line_1",newAddress[0]+",");
        session.setAttribute("New_Line_2",newAddress[1]+",");
        session.setAttribute("New_Province",newAddress[2]+",");
        session.setAttribute("New_District",newAddress[3]+",");
        session.setAttribute("New_City",newAddress[4]+",");
        session.setAttribute("New_Zipcode",newAddress[5]+".");
      

        accountServlet newacc=new accountServlet();
        newacc.account(loggedInEmail,request,response);


    }

}
