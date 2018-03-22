<!-- [mvc27team4] 이춘림  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Teacher List</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<h1>Teacher List</h1>
		<table border = "1">
			<thead>
				<tr>
					<th>teacher_no</th>
					<th>teacher_id</th>
					<th>teacher_pw</th>
					<th>수정</th><!-- ?teacherNo=? --><!-- GuestDao.updateGuest() -->
					<th>삭제</th><!-- GuestDao.deleteGuest() -->
					<th>주소리스트</th><!-- 주소입력 가능 --><!-- GuestAddrDao.insertGuestAddr() 로 가자 -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="teacher" items="${selectTeacher}">
					<tr>
						<td>${teacher.teacherNo}</td>
						<td>${teacher.teacherId}</td>
						<td>${teacher.teacherPw}</td>
						<td><a href="${pageContext.request.contextPath}/modifyTeacher.jjdev?teacherNo=${teacher.teacherNo}">수정</a></td><!-- 티쳐의 넘버가 필요하다. -->
						<td><a href="${pageContext.request.contextPath}/removeTeacher.jjdev?teacherNo=${teacher.teacherNo}">삭제</a></td><!-- 티쳐의 넘버가 필요하다. -->
						<td><a href="${pageContext.request.contextPath}/getTeacherAddrList.jjdev?teacherNo=${teacher.teacherNo}">주소리스트</a></td><!-- 티쳐의 넘버가 필요하다. -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>






















