<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.StudentAddr" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	</head>
	<body>
		<div class="bs-example" data-example-id="simple-table">
		<!-- <button type="button" id="insertAddrButton"><a href="<%=request.getContextPath()%>/addStudentAddr.jjdev">주소추가</a></button>  -->	
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
						<%
							ArrayList<StudentAddr> list = (ArrayList<StudentAddr>)request.getAttribute("studentAddr");
							String studentNoTemp = (String)request.getAttribute("studentNo");
							int studentNo = Integer.parseInt(studentNoTemp);
							System.out.println(studentNo+"<<studentNo getStudentAddrList.jsp");
							for(StudentAddr studentAddr : list){
						%>
						<tr>
							<th scope="row">${studentAddr.studentAddrNo}</th>
							<td>${studentAddr.studentNo}</td>
							<td>${studentAddr.address}</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<button type="button" id="insertAddrButton"><a href="${pageContext.request.contextPath}/addStudentAddr.jjdev?studentNo=${studentNo}">주소추가</a></button>
		</div>
	</body>
</html>