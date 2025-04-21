package com.peace.login_system_3.servlet;

import com.peace.login_system_3.DAO.accountDetails;
import com.peace.login_system_3.DAO.updatePhoneNumber;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="updatePhoneNumberServlet ", urlPatterns ="/updatePhoneNumberServlet")
public class updatePhoneNumberServlet extends HttpServlet {
    String[] info;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String newPhoneNumber=request.getParameter("newPhoneNumber");

        if(newPhoneNumber.isEmpty()){

            request.setAttribute("noValidPhoneNumberError","Please Enter a valid Phone Number");
            getServletContext().getRequestDispatcher("/updatePhoneNumber.jsp").forward(request,response);
        }

        HttpSession session=request.getSession();
       String loggedInEmail=(String) session.getAttribute("loggedInEmail");
        accountDetails details= new accountDetails();
        try {
            info=details.getCustomerDetails(loggedInEmail);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String oldPhoneNumber=info[3];
        updatePhoneNumber update=new updatePhoneNumber();

        try {
            if(update.validatePhoneNumber(newPhoneNumber)) {
                update.changePhoneNumber(loggedInEmail,oldPhoneNumber);
                session.setAttribute("updateConfirmation","Your phone number has been updated to " + newPhoneNumber +" from "+ oldPhoneNumber);
                accountServlet newacc=new accountServlet();
               newacc.account(loggedInEmail,request,response);
 //               response.sendRedirect(request.getContextPath()+"/account.jsp");
     //           getServletContext().getRequestDispatcher("/account.jsp").forward(request,response);
            }
            else{
                request.setAttribute("phoneNumberRegistred","This phone number is already registered.");
                getServletContext().getRequestDispatcher("/updatePhoneNumber.jsp").forward(request,response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
