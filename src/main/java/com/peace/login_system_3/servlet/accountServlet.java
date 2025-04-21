package com.peace.login_system_3.servlet;

import com.peace.login_system_3.DAO.accountDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="accountServlet",urlPatterns ="/account")
public class accountServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String validEmail = request.getParameter("email");

        HttpSession session = request.getSession();
        session.setAttribute("loggedInEmail", validEmail);

        account(validEmail, request, response);


    }

    public void account(String validEmail, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountDetails acc = new accountDetails();
        String[] details;
        String[] Address;
        try {
            acc = new accountDetails();
            details = acc.getCustomerDetails(validEmail);
            Address = acc.getCustomerAddress(validEmail);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String email = details[0];
        String firstName = details[1];
        String lastName = details[2];
        String phoneNumber = details[3];

        request.setAttribute("email", email);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("phoneNumber", phoneNumber);

        String Line1 = Address[0];
        String Line2 = Address[1];
        String Province = Address[2];
        String District = Address[3];
        String City = Address[4];
        String zipCode = Address[5];

        request.setAttribute("Line1", Line1 + ",");
        if (Address[1] != null) {
            request.setAttribute("Line2", Line2 + ",");
        }
        request.setAttribute("Province", Province + ",");
        request.setAttribute("District", District + ",");
        request.setAttribute("City", City + ",");
        request.setAttribute("zipCode", zipCode + ".");

        request.getRequestDispatcher("/account.jsp").forward(request, response);

    }

    }

