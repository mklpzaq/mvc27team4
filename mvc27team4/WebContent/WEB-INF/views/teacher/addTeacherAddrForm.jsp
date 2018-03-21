<!-- [mvc27team4] 이춘림  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Teacher</title>
	</head>
	<body>
		<%
			String temp = request.getParameter("teacherNo");
			int teacherNo = Integer.parseInt(temp);
		%>
		<h3>주소 추가</h3>
		<form id = "teacherAddrForm" action = "<%= request.getContextPath() %>/addTeacherAddr.jjdev" method = "post">
			<label>teacher_no</label>
			<input id = "inputTeacherNo" type = "text" name = "teacherNo" value = "<%=teacherNo%>" readonly>
			<label>address</label>
			<input id = "inputAddr" type = "text" name = "address" placeholder = "주소">
			<input id = "teacherAddrButton" type = "submit" value = "입력완료">
		</form>
	</body>
</html>