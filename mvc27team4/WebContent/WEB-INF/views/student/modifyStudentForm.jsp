<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Student"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
	%>
	<form action="${pageContext.request.contextPath}/modifyStudent.jjdev" method="post">
		<table border="1">
			<tr>
				<td>STUDENT_NO</td>
				<td><input type="text" name="studentNo" value="${student.studentNo}" readonly></td>
			</tr>
			<tr>
				<td>STUDENT_ID</td>
				<td><input type="text" name="studentId" value="${student.studentId}"></td>
			</tr>
			<tr>
				<td>STUDENT_PW</td>
				<td><input type="text" name="studentPw" value="${student.studentPw}"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">수정버튼</button></td>
			</tr>
		</table>
	</form>
</body>
</html>