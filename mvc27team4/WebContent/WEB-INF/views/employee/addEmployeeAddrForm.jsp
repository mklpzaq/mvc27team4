<!-- [mvc27team4] 이준희 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
</head>
	
<body>
	<!-- 
		주소를 추가하기 위해 주소 추가 폼을 만든다.
		직원넘버와 주소를 넘긴다.
	 -->

		<h3>주소추가</h3>
		<form id="employeeAddrForm" action="${pageContext.request.contextPath}/addEmployeeAddr.jjdev" method="post">			
			<label>employee_no</label>
				<input id = "inputEmployeeNo" type = "text" name = "employeeNo" value = "${employeeNo}" readonly>
			<label>address</label>
				<input type="text" name = "address" placeholder = "주소">
				<input id = "employeeAddrButton" type = "submit" value = "입력완료">					
		</form>
</body>
</html> 