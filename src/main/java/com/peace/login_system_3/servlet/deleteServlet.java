package com.peace.login_system_3.servlet;

import com.peace.login_system_3.DAO.Delete;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name="deleteServlet", urlPatterns="/deleteServlet")
public class deleteServlet extends HttpServlet {
Delete delete=new Delete();
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

       String password1= request.getParameter("password1");
       String password2=request.getParameter("password2");

       HttpSession session= request.getSession();
       String email= (String)session.getAttribute("loggedInEmail");


       if(password1.isEmpty()||password2.isEmpty()){

           request.setAttribute("emptyError","Please fill both required fields");
           getServletContext().getRequestDispatcher("/deleteAccount.jsp").forward(request,response);
       }

       else if(password1.equals(password2)){
           try {
               if(delete.confirmPassword(email,password1)){
                   delete.deleteAddress(email);
                   delete.deleteCredentials(email);
                   delete.deleteDetails(email);
                   getServletContext().getRequestDispatcher("/accountDeleted.jsp").forward(request,response);
               }
               else{
                   request.setAttribute("passwordIncorrect","The password You entered is incorrect");
                   getServletContext().getRequestDispatcher("/deleteAccount.jsp").forward(request,response);
               }
           } catch (Exception e) {
               throw new RuntimeException(e);
           }

       }
       else{
           request.setAttribute("passwordMismatch","The passwords do not match");
           getServletContext().getRequestDispatcher("/deleteAccount.jsp").forward(request,response);
       }

    }

}
