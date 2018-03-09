<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import= "service.Employee" %>
<%@ page import= "service.EmployeeDao" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
	<h1>Employee List</h1>
	<%
		EmployeeDao employeedao = new EmployeeDao();
		ArrayList<Employee> list = employeedao.SelectEmployee();
	%>
	<%
	
	%>
	
</body>
</html>