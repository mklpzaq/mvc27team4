<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<th>수정</th>
				<th>삭제</th>
				<th>List STUDENT_ADDR</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${list}">
				<tr>
					<td>${student.studentNo}</td>
					<td>${student.studentId}</td>
					<td>****</td>
					<td><a href="${pageContext.request.contextPath}/modifyStudent.jjdev?studentNo=${student.studentNo}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/removeStudent.jjdev?studentNo=${student.studentNo}">삭제</a></td>
					<td><a href="${pageContext.request.contextPath}/getStudentAddrList.jjdev?studentNo=${student.studentNo}">주소리스트</a></td>
				</tr>
			</c:forEach>
			
			<%-- <tr>
			<%
				ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
				for(Student student : list) {
			%>
				<td><%=student.getStudentNo() %></td>
				<td><%=student.getStudentId() %></td>
				<td>****</td>
				<td><a href="<%=request.getContextPath()%>/modifyStudent.jjdev?studentNo=<%=student.getStudentNo()%>">수정</a></td>
				<td><a href="<%=request.getContextPath()%>/removeStudent.jjdev?studentNo=<%=student.getStudentNo()%>">삭제</a></td>
				<td><a href="<%=request.getContextPath()%>/getStudentAddrList.jjdev?studentNo=<%=student.getStudentNo()%>">주소리스트</a></td>
			</tr>
			<%
				}
			%> --%>
		</tbody>
	</table>
</body>
</html>