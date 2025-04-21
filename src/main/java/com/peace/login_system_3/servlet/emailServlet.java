package com.peace.login_system_3.servlet;

import com.peace.login_system_3.DAO.newEmailValidate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="emailServlet",urlPatterns ="/emailS")
public class emailServlet extends HttpServlet {
    newEmailValidate validate=new newEmailValidate();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String email= request.getParameter("email");
       String phoneNumber = request.getParameter("phoneNumber");

       if(email.isEmpty()||phoneNumber.isEmpty())
       {
           request.setAttribute("emailEmptyError","Please Enter a valid  Email and Phone Number");
           getServletContext().getRequestDispatcher("/email.jsp").forward(request,response);
       }

        try {
            if (!validate.validateEmail(email)) {
                request.setAttribute("emailExistsError", "Email is already registered");
                getServletContext().getRequestDispatcher("/email.jsp").forward(request, response);
            } else if (!validate.validatePhoneNumber(phoneNumber)) {
                request.setAttribute("phoneExistsError", "Phone Number is already registered");
                getServletContext().getRequestDispatcher("/email.jsp").forward(request, response);
            }

    else {
            HttpSession session = request.getSession();
            session.setAttribute("validEmail", email);
            session.setAttribute("validPhoneNumber",phoneNumber);

            getServletContext().getRequestDispatcher("/signUp.jsp").forward(request, response);

                }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
        }
