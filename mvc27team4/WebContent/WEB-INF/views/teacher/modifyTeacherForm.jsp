<!-- [mvc27team4] 이춘림  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>update Teacher</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			//폼 유효성 검사 후 폼을 submit
			$("#updateButton").click(function(){
				$("#updateForm").submit();
			});
		});
	</script>
</head>
<body>
	<h3>UPDATE FORM</h3>
	<form id = "updateForm" action="${pageContext.request.contextPath}/modifyTeacher.jjdev" method="post">
		<table border="1">
		<tr>
			<td>teacherNo</td>
			<td><input id = "inputTeacherNo" type="text" name="teacherNo" size="20" value="${oneTeacher.teacherNo}" readonly></td>
		<tr>
		<tr>
			<td>teacherId</td>
			<td><input id = "inputTeacherId" type="text" name="teacherId" size="20" value="${oneTeacher.teacherId}"></td>
		<tr>
		<tr>
			<td>teacherPw</td>
			<td><input id = "inputTeacherPw" type="text" name="teacherPw" size="20" value="${oneTeacher.teacherPw}"></td>
		<tr>
		<tr>
			<td colspan = "2"><button id = "updateButton" type="button">수정 완료</button></td>
		<tr>
		</table>
	</form>
</body>
</html>