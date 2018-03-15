<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "model.Student"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
	%>
	<form action="<%=request.getContextPath() %>/">
		<table border="1">
		<thead>
			<tr>
				<th>STUDENT_NO</th>
				<th>STUDENT_ID</th>
				<th>STUDENT_PW</th>
				<th>ADDR STUDENT_ADDR</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>				
		</table>
	</form>
</body>
</html>