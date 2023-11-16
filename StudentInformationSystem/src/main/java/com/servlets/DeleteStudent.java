package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDetailsDAO;
import com.dao.StudentDetailsDAOImpl;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id=Integer.parseInt(request.getParameter("id"));	
		 StudentDetailsDAO studentDAO = new StudentDetailsDAOImpl();
		  boolean updated = studentDAO.deleteStudent(id);


	        if (updated) {
	            response.sendRedirect("AdminView.jsp");
	        } else {
	        	
	            response.getWriter().println("Failed to update student details.");
	        }
	}

}
