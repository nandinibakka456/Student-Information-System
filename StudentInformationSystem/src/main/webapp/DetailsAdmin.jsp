<%@ page import="java.util.List" %>
<%@ page import="com.model.Student" %>
<%@ page import="com.dao.StudentDetailsDAO" %>
<%@ page import="com.dao.StudentDetailsDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
         #edit{
           float:right;
           height:50px;
           weight:200px;
           background-color:blue;
                    color:white;
         font-size:15px;
         border-radius:10px;
            }
            
          #edit a{
          color:white;
          }
         
    </style>
</head>
<body>
    <h1>Student Details</h1>
    
    

<br><br>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>College</th>
            <th>Degree</th>
            <th>Branch</th>
        </tr>
        <%
      

    String redirectToEdit = request.getParameter("redirectToEdit");
    if (redirectToEdit != null && redirectToEdit.equals("true")) {
        response.sendRedirect("editStudent.jsp");
    }
%>
        
        <%
            StudentDetailsDAO studentDAO = new StudentDetailsDAOImpl();
            List<Student> students = studentDAO.getAllStudents();
            for (Student student : students) {
        %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getPhoneNumber() %></td>
                <td><%= student.getCollege() %></td>
                <td><%= student.getDegree() %></td>
                <td><%= student.getBranch() %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
