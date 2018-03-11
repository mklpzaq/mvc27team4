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
		<div class = "row">
			<div class = "col-sm-3"></div>
			<div class = "col-sm-6">
				<h1>TeacherList</h1>
				<div class = "table-responsive">
					<table class = "table table-hover">
						<tr>
							<th>teacher_no</th>
							<th>teacher_id</th>
							<th>teacher_pw</th>
						</tr>
						<%
							for(Teacher teacher : list){
						%>
								<tr>
									<td><%= teacher.getTeacherNo() %></td>
									<td><%= teacher.getTeacherId() %></td>
									<td><%= teacher.getTeacherPw() %></td>
								</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
			<div class = "col-sm-3"></div>
		</div>
	</body>
</html>






















