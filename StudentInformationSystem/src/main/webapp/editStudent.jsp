<%@ page import="com.model.Student" %>
<%@ page import="com.dao.StudentDetailsDAO" %>
<%@ page import="com.dao.StudentDetailsDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student Details</title>
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
        

        form {
            width: 50%;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        label, input {
            display: block;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Edit Student Details</h1>
    <form action="updateStudent" method="post">
        <%
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                int studentId = Integer.parseInt(idParam);
                StudentDetailsDAO studentDAO = new StudentDetailsDAOImpl();
                Student student = studentDAO.getStudentById(studentId);
                
                if (student != null) {
        %>
            <input type="hidden" name="id" value="<%= student.getId() %>">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" readonly value="<%= student.getName() %>">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"  readonly value="<%= student.getEmail() %>">
            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone" value="<%= student.getPhoneNumber() %>">
            <label for="college">College:</label>
            <input type="text" id="college" name="college" value="<%= student.getCollege() %>">
            <label for="degree">Degree:</label>
            <input type="text" id="degree" name="degree" value="<%= student.getDegree() %>">
            <label for="branch">Branch:</label>
            <input type="text" id="branch" name="branch" value="<%= student.getBranch() %>">
            <input type="submit" value="Save">
        <%
                } else {
                    out.println("Student details not found for ID: " + studentId);
                }
            } else {
                out.println("Invalid ID parameter");
            }
        %>
    </form>
</body>
</html>
