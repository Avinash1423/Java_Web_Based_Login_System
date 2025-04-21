package com.peace.login_system_3.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="newUserServlet" , urlPatterns = "/newUser")
public class newUser extends HttpServlet {

    String[] newDetails;
    String email;
    String firstName;
    String lastName;
    String phoneNumber;

    String[] newAddress;
    String Line_1;
    String Line_2;
    String Province;
    String District;
    String City;
    String zipCode;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

             firstName=request.getParameter("firstName");
             lastName=request.getParameter("lastName");
            // phoneNumber=request.getParameter("phoneNumber");

              Line_1=request.getParameter("Line_1");
              Line_2=request.getParameter("Line_2");
              Province=request.getParameter("Province");
              District=request.getParameter("District");
              City=request.getParameter("City");
              zipCode=request.getParameter("zipCode");

              if(firstName.isEmpty()||lastName.isEmpty()){
                  request.setAttribute("basicDetailsError","Please Provide all Basic Details");
                  getServletContext().getRequestDispatcher("/signUp.jsp").forward(request,response);
              }

              if(Line_1.isEmpty()||Province.isEmpty()||District.isEmpty()||City.isEmpty()||zipCode.isEmpty()){
                  request.setAttribute("addressError","Please Provide all  Required Address Details");
                  getServletContext().getRequestDispatcher("/signUp.jsp").forward(request,response);
              }

        newDetails= new String[]{firstName, lastName};
        newAddress=new String[]{Line_1,Line_2,Province,District,City,zipCode};

        HttpSession session=request.getSession();

        session.setAttribute("getnewDetails",newDetails);
        session.setAttribute("getnewAddress",newAddress);

        getServletContext().getRequestDispatcher("/password.jsp").forward(request,response);

    }


}
