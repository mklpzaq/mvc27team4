<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "model.StudentDao" %>
<%@ page import = "model.Student" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Student List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>student_no</th>
				<th>student_id</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<%
				StudentDao studentDao = new StudentDao();
				ArrayList<Student> list = studentDao.selectStudent();
				for(Student student : list) {
			%>
				<td><%=student.getStudentNo() %></td>
				<td><%=student.getStudentId() %></td>
			<%
				}
			%>
			</tr>
		</tbody>
	</table>
</body>
</html>