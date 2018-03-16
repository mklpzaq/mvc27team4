<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="<%=request.getContextPath() %>/addStudentAddr.jjdev"  id="studentAddrForm" method="post">
			<h3>주소추가</h3>
			<input type="text" name="address" placeholder="주소를 입력하세요.">
			<button type="submit">추가버튼</button>
		</form>
	</body>
</html>