<!-- [mvc27team4] 이준희 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			
	<title></title>
	</head>
	<body>
	<!-- 
		GetEmployeeAddrListController 에서 처리된것을 화면에 보여줘야 한다.
		setAttribute로 값을 담아 놨기 때문에 화면에서는 getAttribute로 값을 받아와서 화면에 뿌려준다.
		주소를 추가 할때는 한명의 직원에 해당하는 주소를 찍어 내야 한다. 그 직원이 가지고 있는 넘버로 get방식으로 넘겨준다.
	 -->
		<div class="bs-example" data-example-id="simple-table">			
			<table class="table">
				<caption>Optional table caption.</caption>
					<thead>
						<tr>
							<th>employee_addr_no</th>
							<th>employee_no</th>
							<th>address</th>						
						</tr>
					</thead>
					<tbody>
						${list} 
						<c:forEach var="employeeAddr" items="${addrlist}">
							<tr>
								<th scope="row">${employeeAddr.employeeAddrNo}</th>
								<td>${employeeAddr.employeeNo}</td>
								<td>${employeeAddr.address()}</td>						
							</tr>
						</c:forEach>				
											
					</tbody>
				</table>
		<button id="insertAddrButton" type="button"><a href="${pageContext.request.contextPath}/addEmployeeAddr.jjdev?employeeNo= ${employeeNo}">주소추가</a></button>
			</form>
		</div>	
		
	</body>
</html>