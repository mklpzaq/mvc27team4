<!-- [mvc27team4] 이춘림 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Teacher" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Teacher List</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	</head>
	<body>
		<%
			ArrayList<Teacher> list = (ArrayList<Teacher>)request.getAttribute("selectTeacher");	
			
		%>
		
		<h1>GuestList</h1>
		<table>
			<thead>
				<tr>
					<th>teacher_no</th>
					<th>teacher_id</th>
					<th>teacher_pw</th>
				</tr>
			</thead>
			<%
				for(Teacher teacher : list){
			%>
			<tbody>
				<tr>
					<td><input type = "text" name = "text" value = "<%= teacher.getTeacherNo() %>" readonly></td>
					<td><input type = "text" name = "text" value = "<%= teacher.getTeacherId() %>"></td>
					<td><input type = "text" name = "text" value = "<%= teacher.getTeacherPw() %>"></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
	</body>
</html>