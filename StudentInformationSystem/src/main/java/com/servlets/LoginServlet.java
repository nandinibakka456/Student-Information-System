package com.servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dao.DBConnectionManager;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginStudent")
public class LoginServlet extends HttpServlet {

    
    
    private boolean validateUser(String username, String password) {
        try  {
        	Connection connection = new DBConnectionManager().getConnection();
            String sql = "SELECT * FROM register_info WHERE email=? AND password=?";
          
            	PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                    return resultSet.next();
                
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        
    }
        }
        

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValidUser = validateUser(username, password);

        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("Details.jsp?email=" + username); 
        } else {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginStudent.html");
            dispatcher.forward(request, response);
        }
    }
}
