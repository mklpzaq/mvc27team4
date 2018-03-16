<!-- [mvc27team4] 이준희 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
</head>
	
<body>
		<h3>주소추가</h3>
		<form id="employeeAddrForm" action="<%= request.getContextPath() %>/addEmployeeAddr.jjdev" method="post">			
			<input type="text" name = "address">
			<button id="employeeAddrButton" type="sunmit">주소추가</button>					
		</form>
</body>
</html>