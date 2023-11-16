<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button {
            padding: 10px 20px;
            font-size: 18px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            margin: 5px;
        }

        .button.view {
            background-color: #007bff;
            color: #fff;
        }

        .button.add {
            background-color: #28a745;
            color: #fff;
        }

        .button.delete {
            background-color: #dc3545;
            color: #fff;
        }
    </style>
</head>
<body>
    <h1>Student Details</h1>

    <div class="button-container">
        <button class="button view" onclick="window.location.href='StudentDetails.jsp'">View Details</button>
        <button class="button add" onclick="window.location.href='addStudent.jsp'">Add Student</button>
        <button class="button delete" onclick="window.location.href='deleteStudent.jsp'">Delete Student</button>
    </div>

    <table>
        <!-- Your table content goes here -->
    </table>
</body>
</html>

</body>
</html>