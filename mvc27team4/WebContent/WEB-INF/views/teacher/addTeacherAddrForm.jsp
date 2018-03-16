<!-- [mvc27team4] 이춘림  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>주소 추가</h3>
			<form id = "teacherAddrForm" action = "<%= request.getContextPath() %>/addTeacherAddr.jjdev" method = "post">
			<input id = "inputAddr" type = "text" name = "address" placeholer = "주소입력">
			<input id = "teacherAddrButton" type = "submit">
		</form>
	</body>
</html>