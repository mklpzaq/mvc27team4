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
	
	
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<!-- Begin Contants -->
						<h1>Teacher List</h1>
						<table class="table table-bordered">
						 	<thead>
						 		<tr>
							 		<th>teacher_no</th>
									<th>teacher_id</th>
									<th>teacher_pw</th>
									<th>수정</th>
									<th>삭제</th>
									<th>주소리스트</th>
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
						
						<!-- Begin 페이지 네이션 -->
						<nav>
							<ul class="pagination">
								<li>
									<a href="${pageContext.request.contextPath}/getTeacherList.jjdev?currentPage=1" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<!-- lastPage -->
								<c:forEach var="pageNum" begin="1" end="${lastPage}" step="1">
									<li><a href="${pageContext.request.contextPath}/getTeacherList.jjdev?currentPage=${pageNum}">${pageNum}</a></li>
								</c:forEach>
								<li>
									<a href="${pageContext.request.contextPath}/getTeacherList.jjdev?currentPage=${lastPage}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</nav>
						<!-- End 페이지 네이션 -->
						
						
						
					<!-- End Contants -->
				</div>
				<div class="col-sm-3"></div>
			</div>
		</div>
		
	<%-- 	<a href="">처음으로</a>
		<!-- 1페이지 일때 이전은 없다. 현재페이지보다 1보다 클때만 동장해줘어야 한다. -->
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/getTeacherList.jjdev?currentPage=${currentPage-1}">이전</a><!--  -->
		</c:if>
		
		<c:forEach var="number" items="">
			<!-- 넘버링 -->
		</c:forEach>
		
		
		<!-- 50개면 5페이지 65개면 7페이지 71개면 8페이지 -->
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/getTeacherList.jjdev?currentPage=${currentPage+1}">다음</a><!--  -->
		</c:if>
		<a href="">마지막으로</a>
	 --%>	
		
	</body>
</html>






















