<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ page import = "model.Teacher" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		//request.setCharacterEncoding("UTF-8");
		Teacher teacher = (Teacher)request.getAttribute("oneTeacher");
	%>
	<h3>UPDATE FORM</h3>
	<form action="<%= request.getContextPath() %>/mupdate/m_update_pro.jsp" method="post">
		<table border="1">
		<tr>
			<td>teacherNo</td>
			<td><input type="text" name="teacher_no" size="20" value="<%= teacher.getTeacherNo() %>" readonly></td>
		<tr>
		<tr>
			<td>teacherId</td>
			<td><input type="text" name="teacher_id" size="20" value="<%= teacher.getTeacherId() %>"></td>
		<tr>
		<tr>
			<td>teacherPw</td>
			<td><input type="text" name="teacher_pw" size="20" value="<%= teacher.getTeacherPw() %>"></td>
		<tr>
		<tr>
			
			<td colspan = "2"><input type="submit" value="수정 완료"></td>
		<tr>
		</table>
	</form>
</body>
</html>