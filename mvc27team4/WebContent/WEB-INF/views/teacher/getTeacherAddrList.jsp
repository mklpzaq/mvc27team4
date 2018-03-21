<!-- [mvc27team4] 이춘림  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.TeacherAddr" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>teacher list</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<%
			String temp = request.getParameter("teacherNo");
			int teacherNo = Integer.parseInt(temp);
		%>
	
		<div class="bs-example" data-example-id="simple-table">
				<a href="<%=request.getContextPath()%>/getTeacherList.jjdev"><button id="backTeacherListButton" type="button">TeacherList로 이동</button></a>
				<a href="<%=request.getContextPath()%>/addTeacherAddr.jjdev?teacherNo=<%=teacherNo%>"><button id="insertAddrButton" type="button">주소추가</button></a>
				<table class="table" border="1">
					<caption>teacher addr list</caption>
					<thead>
						<tr>
							<th>teacher_addr_no</th>
							<th>teacher_no</th>
							<th>address</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<TeacherAddr> list = (ArrayList<TeacherAddr>)request.getAttribute("teacherAddrList");
							for(TeacherAddr teacherAddr : list){
						%>
						<tr>
							<th scope="row"><%= teacherAddr.getTeacherAddrNo() %></th>
							<td><%= teacherAddr.getTeacherNo() %></td>
							<td><%= teacherAddr.getAddress() %></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				
				
		 </div>
	</body>
</html>