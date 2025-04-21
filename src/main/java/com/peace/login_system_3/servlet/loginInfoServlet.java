package com.peace.login_system_3.servlet;

import com.peace.login_system_3.DAO.accountDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import com.peace.login_system_3.DAO.validateInput;

//import static com.peace.login_system_3.DAO.validateInput.validate;
//import static com.peace.login_system_3.DAO.validateInput.validateCredentials;

@WebServlet(name="loginInfoServlet", urlPatterns ="/loginInfoServlet")
public class loginInfoServlet  extends HttpServlet {

    String email;
    String password;
    validateInput validateInput=new validateInput();


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        email=request.getParameter("email");
        password=request.getParameter("password");

        if(email.isEmpty()|| password.isEmpty()){
            request.setAttribute("emptyError","Please Enter Valid Email and Password");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        } else {
            try {
                if(!validateInput.validate(email)) {
                    request.setAttribute("wrongEmailError", "Account does not exist");
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
                }
                else{
                    if(!validateInput.validateCredentials(email,password)){
                        request.setAttribute("wrongPasswordError","Credentials Invalid");
                        getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
                    }
                    else{

                        request.getRequestDispatcher("/account").forward(request,response);

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);

            }
        }

    }


}
