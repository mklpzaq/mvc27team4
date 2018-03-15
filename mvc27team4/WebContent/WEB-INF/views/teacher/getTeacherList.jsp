<!-- [mvc27team4] 이춘림 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Teacher" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Teacher List</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
<<<<<<< HEAD
		<h1>GuestList</h1>
		<table>
			<thead>
				<tr>
					<th>teacher_no</th>
					<th>teacher_id</th>
					<th>teacher_pw</th>
					<th>수정</th><!-- ?teacherNo=? --><!-- GuestDao.updateGuest() -->
					<th>삭제</th><!-- GuestDao.deleteGuest() -->
					<th>ADD TEACHER_ADDR</th><!-- 주소입력 가능 --><!-- GuestAddrDao.insertGuestAddr() 로 가자 -->
				</tr>
			</thead>
			<tbody>
			<%
				ArrayList<Teacher> list = (ArrayList<Teacher>)request.getAttribute("selectTeacher");
				for(Teacher teacher : list){
			%>
					<tr>
						<td><%= teacher.getTeacherNo() %></td>
						<td><%= teacher.getTeacherId() %></td>
						<td><%= teacher.getTeacherPw() %></td>
						<td><a href="<%=request.getContextPath()%>/modifyTeacher.jjdev?teacherNo=<%=teacher.getTeacherNo()%>">수정</a></td><!-- 티쳐의 넘버가 필요하다. -->
						<td><a href="<%=request.getContextPath()%>/removeTeacher.jjdev?teacherNo=<%=teacher.getTeacherNo()%>">삭제</a></td><!-- 티쳐의 넘버가 필요하다. -->
						<td><a href="<%=request.getContextPath()%>/addTeacherAddr.jjdev?teacherAdderNo=<%=teacher.getTeacherNo()%>">주소추가</a></td><!-- 티쳐의 넘버가 필요하다. -->
						
						
						<td><a href="">삭제</a></td><!-- 티쳐의 넘버가 필요하다. -->
						<td><a href="">수정</a></td><!-- 티쳐의 넘버가 필요하다. -->
						
					</tr>
			<%
				}
			%>
			</tbody>
		</table>
=======
		<%
			ArrayList<Teacher> list = (ArrayList<Teacher>)request.getAttribute("selectTeacher");
		%>
		<div class = "row">
			<div class = "col-sm-3"></div>
			<div class = "col-sm-6">
				<h1>TeacherList</h1>
				<div class = "table-responsive">
					<table class = "table table-hover">
						<tr>
							<th>teacher_no</th>
							<th>teacher_id</th>
							<th>teacher_pw</th>
						</tr>
						<%
							for(Teacher teacher : list){
						%>
								<tr>
									<td><%= teacher.getTeacherNo() %></td>
									<td><%= teacher.getTeacherId() %></td>
									<td><%= teacher.getTeacherPw() %></td>
								</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
			<div class = "col-sm-3"></div>
		</div>
>>>>>>> refs/remotes/origin/master
	</body>
</html>






















