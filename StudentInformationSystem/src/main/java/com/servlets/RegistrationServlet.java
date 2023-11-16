package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.RegistrationDTO;
import com.dao.RegistrationDAO;
import com.dao.RegistrationDAOImpl;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
        RegistrationDTO registrationDTO = new RegistrationDTO(name, email, password);

        RegistrationDAO registrationDAO = new RegistrationDAOImpl();

        
        boolean registrationSuccessful = registrationDAO.registerUser(registrationDTO);

        if (registrationSuccessful) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("register.html"); 
        }
    }
}
