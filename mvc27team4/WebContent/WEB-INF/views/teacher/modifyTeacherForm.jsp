<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ page import = "model.Teacher" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<%
		Teacher teacher = (Teacher)request.getAttribute("oneTeacher");
	%>
	<form action="<%= request.getContextPath() %>/mupdate/m_update_pro.jsp" method="post">
		<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="m_id" size="20" value="" readonly></td>
		<tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="m_pw" size="20" value="<%=  %>"></td>
		<tr>
		<tr>
			<td>권한</td>
			<td><input type="text" name="m_level" size="20" value="<%=  %>"></td>
		<tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="m_name" size="20" value="<%=  %>"></td>
		<tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="m_email" size="20" value="<%=  %>"></td>
		<tr>
		<tr>
			<td colspan="4"><input type="submit" value="회원수정버튼"></td>
		</tr>
		</table>
	</form>
</body>
</html>