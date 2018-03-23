<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	</head>
	<body>
		<%System.out.println("getStudentList.jsp 시작");%>
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
			</tbody>
		</table>
		<nav>
			<ul class="pagination">
				<li>
					<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=1" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
					<c:forEach var="i" begin="1" end="${lastPage}" step="1">
						<li><a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${i}">${i}</a></li>
					</c:forEach>
				<li>
					<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${lastPage}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</nav>
		
		<%-- <c:if test="${currentPage>1}">
			<a href="${pageContext.request.contextPath}/getStudentList.jjdev">처음으로</a>
		</c:if>
		<c:if test="${currentPage>1}">
			<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${currentPage-1}">이전</a>
		</c:if>
		<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${currentPage+1}">다음</a>
		</c:if>
		<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${lastPage}">마지막으로</a>
		</c:if>
		<%System.out.println("getStudentList.jsp 마침");%> --%>
		
	</body>
</html>