<!-- [mvc27team4] ��ο� -->
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
				<th>STUDENT_NO</th>
				<th>STUDENT_ID</th>
				<th>STUDENT_PW</th>
				<th>����</th>
				<th>����</th>
				<th>ADDR STUDENT_ADDR</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<%
				ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
				for(Student student : list) {
			%>
				<td><%=student.getStudentNo() %></td>
				<td><%=student.getStudentId() %></td>
				<td>****</td>
				<td><a href="<%=request.getContextPath()%>/modifyStudent.jjdev?studentNo=<%=student.getStudentNo()%>">����</a></td>
				<td><a href="<%=request.getContextPath()%>/removeStudent.jjdev?studentNo=<%=student.getStudentNo()%>">����</a></td>
				<td><a href="<%=request.getContextPath()%>/addrStudentAddr.jjdev?studentAddrNo=<%=student.getStudentNo()%>">�ּ��߰�</a></td>
			<%
				}
			%>
			</tr>
		</tbody>
	</table>
</body>
</html>