<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirm Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
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

      

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        h1{
        color:green;
        font-size:30px;
        }
    </style>
</head>
<body>
<h1>Confirm Details</h1>
    <form action="editStudent.jsp" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id"><br><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br><br>
        <label for="email">Email:</label>
<input type="email" id="email" name="email" value="<%= request.getParameter("email") %>" readonly><br> <br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
