<!-- [mvc27team4] 이준희 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Employee" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Update form</title>
</head>
<body>
<%
	Employee employee = (Employee)request.getAttribute("oneEmployee");
	System.out.println("getEmployeeUpdateForm.jsp 들어옴");
	employee.toString();
%>

	<br>
	<br>
<form class="form-horizontal" action="<%=request.getContextPath()%>/ModifyEmployee.jjdev" method="post">
	<div class="form-group">
		<label for="inputEmployeeNo3" class="col-sm-2 control-label">EmployeeNo</label>
	<div class="col-sm-10">
		<input type="text" class="form-control" id="EmployeeNo3" name="EmployeeNo" value="<%= employee.getEmployeeNom()%>" readonly>
	</div>
	</div>
	<div class="form-group">
		<label for="inputEmployeeId3" class="col-sm-2 control-label">EmployeeId</label>
	<div class="col-sm-10">
		<input type="text" class="form-control" id="EmployeeId3" name="EmployeeId" value="<%= employee.getEmployeeId()%>">
	</div>
	</div>
	<div class="form-group">
		<label for="inputEmployeePw3" class="col-sm-2 control-label">EmployeePw</label>
	<div class="col-sm-10">
		<input type="password" class="form-control" id="EmployeePw3" name="EmployeePw" value="<%= employee.getEmployeePw()%>">
	</div>
	</div>
	<div class="form-group">
	<div class="col-sm-offset-2 col-sm-10">
		<button type="submit" class="btn btn-default">수정버튼</button>
	</div>
	</div>
</form>
	
	
	
</body>
</html>