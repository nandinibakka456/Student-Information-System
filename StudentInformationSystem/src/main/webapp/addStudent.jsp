<%@ page import="com.model.Student" %>
<%@ page import="com.dao.StudentDetailsDAO" %>
<%@ page import="com.dao.StudentDetailsDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student Details</title>
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
    <h1>Add Student Details</h1>
    <form action="addStudent" method="post">  
         	<label type="text">Id:</label>
            <input type="text" name="id" value="">
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"  value="">
            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone" value="">
            <label for="college">College:</label>
            <input type="text" id="college" name="college" value="">
            <label for="degree">Degree:</label>
            <input type="text" id="degree" name="degree" value="">
            <label for="branch">Branch:</label>
            <input type="text" id="branch" name="branch" value="">
            <input type="submit" value="Save">
       
    </form>
</body>
</html>
