package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDetailsDAO;
import com.dao.StudentDetailsDAOImpl;
import com.model.Student;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String college = request.getParameter("college");
        String Degree = request.getParameter("degree");
        String Branch = request.getParameter("branch");

        // Create a Student object with updated details
        Student updatedStudent = new Student(id, name, email, phone, college, Degree, Branch);

        // Update the student details in the database
        StudentDetailsDAO studentDAO = new StudentDetailsDAOImpl();
        boolean updated = studentDAO.updateStudent(updatedStudent);

       

        if (updated) {
            response.sendRedirect("Details.jsp");
        } else {
        	
            response.getWriter().println("Failed to update student details.");
        }
    }
}
