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
		<script>
			$(document).ready(function(){
				$("#deleteAddrButton").click(function(){
					$("#addrListForm").submit();
				});
				
				$("#allDeleteAddrCheck").click(function(){
					if($("#allDeleteAddrCheck").prop("checked")) {
						$("input[type=checkbox]").prop("checked", true);
					}else{
						$("input[type=checkbox]").prop("checked", false);
					}
				});
			});
		</script>
	</head>
	<body>
	<%System.out.print("getStudentAddrList.jsp로넘어왔음."); %>
	
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
				<!-- Begin Contents -->
				
				
					<button class="btn btn-default" type="button"><a href="${pageContext.request.contextPath}/getStudentList.jjdev">StudentList</a></button>
					<button class="btn btn-default" type="button"><a href="${pageContext.request.contextPath}/addStudentAddr.jjdev?studentNo=${studentNo}">주소추가</a></button>
					<button class="btn btn-default" type="button" id="deleteAddrButton">주소삭제</button>
					<table class="table table-striped">
						<form id="addrListForm" action="${pageContext.request.contextPath}/removeStudentAddr.jjdev" method="post">
							<input type="hidden" name="studentNo" value="${studentNo}">
							<caption>studentAddr</caption>
							<thead>
								<tr>
									<th><input type = "checkbox" id="allDeleteAddrCheck">전체삭제</th>
									<th>student_addr_no</th>
									<th>student_no</th>
									<th>address</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="studentAddr" items="${studentAddr}">								
								<tr>
									<td><input type="checkbox" id="deleteAddrCheck" name="deleteAddrCheck" value="${studentAddr.studentAddrNo}"></td>
									<td scope="row">${studentAddr.studentAddrNo}</td>
									<td>${studentAddr.studentNo}</td>
									<td>${studentAddr.address}</td>
								</tr>
								</c:forEach>
							</tbody>
						</form>
					</table>
				
				
				
				
				<!-- End Contents -->
				</div>
				<div class="col-sm-3"></div>
			</div>
		</div>
	</body>
</html>