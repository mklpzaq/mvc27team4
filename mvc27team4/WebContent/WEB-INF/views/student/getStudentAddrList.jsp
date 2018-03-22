<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	</head>
	<body>
	<%System.out.print("getStudentAddrList.jsp로넘어왔음."); %>
		<div class="bs-example" data-example-id="simple-table">
			<table class="table">
				<caption>Optional table caption.</caption>
				<thead>
					<tr>
						<th>student_addr_no</th>
						<th>student_no</th>
						<th>address</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="studentAddr" items="${studentAddr}">
					<%System.out.print("getStudentAddrList.jsp에서 forEach문 시작."); %>
					<%-- <%
						ArrayList<StudentAddr> list = (ArrayList<StudentAddr>)request.getAttribute("studentAddr");
						String studentNoTemp = (String)request.getAttribute("studentNo");
						int studentNo = Integer.parseInt(studentNoTemp);
						System.out.println(studentNo+"<<studentNo getStudentAddrList.jsp");
						for(StudentAddr studentAddr : list){
					%> --%>
					<tr>
						<th scope="row">${studentAddr.studentAddrNo}</th>
						<td>${studentAddr.studentNo}</td>
						<td>${studentAddr.address}</td>
					</tr>
					</c:forEach>
					<%System.out.print("getStudentAddrList.jsp에서 forEach문 마침."); %>
				</tbody>
			</table>
				<button type="button"><a href="${pageContext.request.contextPath}/addStudentAddr.jjdev?studentNo=${studentNo}">주소추가</a></button>
		</div>
	</body>
</html>