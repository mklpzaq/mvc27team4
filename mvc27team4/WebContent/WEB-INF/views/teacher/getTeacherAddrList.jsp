<!-- [mvc27team4] 이춘림  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>teacher list</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
		/* $(document).ready(function(){
			//폼 유효성 검사 후 폼을 submit
			$("#insertTeacherBtn").click(function(){
				
				 if( $("#teacherId").val().length < 2 ){
					$("#helper").text("2자 이상 입력해주세요.");
				}else if( $("#teacherPw").val() === "" ){
					$("#helper").text("비밀번호를 입력하여 주십시오.");
				}else if( $("#teacherPwCheck").val() !== $("#teacherPw").val() ){
					$("#helper").text("확인 비밀번호를 정확히 입력해주세요.");
				}else{
					$("#helper").text("");
					$("#insertTeacherForm").submit();
				}
 
			});
		}); */
	</script>
	</head>
	<body>
		<%-- <%
			String temp = request.getParameter("teacherNo");
			int teacherNo = Integer.parseInt(temp);
		%> --%>
		getTeacherAdderList.jsp
		<div class = "row">
			<div class = "col-sm-2"></div>
			<div class = "col-sm-8">
				<div class="bs-example" data-example-id="simple-table">
					<a href="${pageContext.request.contextPath}/getTeacherList.jjdev"><button id="backTeacherListButton" type="button">TeacherList로 이동</button></a>
					<a href="${pageContext.request.contextPath}/addTeacherAddr.jjdev?teacherNo=${teacherNo}"><button id="insertAddrButton" type="button">주소추가</button></a>
					
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
								<c:forEach var="teacherAddr" items="${teacherAddrList}">
									<tr>
										<th scope="row">${teacherAddr.teacherAddrNo}</th>
										<td>${teacherAddr.teacherNo}</td>
										<td>${teacherAddr.address}</td>
									</tr>
								</c:forEach>
							</tbody>
						
					</table>
				 </div>
			 </div>
			 <div class = "col-sm-2"></div>
		 </div>
		 
	</body>
</html>