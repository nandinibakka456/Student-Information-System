<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            text-align: center;
        }

        h1 {
            color: green;
        }

        p {
            font-size: 18px;
        }

        a {
            display: block;
            font-size: 20px;
            margin: 10px 0;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Welcome Admin !</h1>
    <p>Here you can view, add, and delete student details.</p>
    <a href="AdminView.jsp">View Student Details</a>
    <a href="addStudent.jsp">Add New Student</a>
    <a href="deleteStudent.jsp">Delete Student</a>
</body>
</html>
