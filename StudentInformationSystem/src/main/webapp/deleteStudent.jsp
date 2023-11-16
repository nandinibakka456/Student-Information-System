<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<style type="text/css">

h2{

	margin-top:50px;
   text-align:center;
   color:blue;
   
}

form{
margin-top:100px;
border:1px solid black;
padding:40px;
width:200px;
}
div{
align-items:center;
margin-left:40%;
margin-right:50%;

}

</style>
<meta charset="UTF-8">
<title>Delete Student Details</title>
</head>
<body>
<h2> Enter Student Id to delete details </h2>
<div>
<form align="center" action="deleteStudent" method="post">

<label type="text">Id: </label>
<input type="text" name="id">
<br>
<br>
<input type="submit">


</form>

</div>
</body>
</html>