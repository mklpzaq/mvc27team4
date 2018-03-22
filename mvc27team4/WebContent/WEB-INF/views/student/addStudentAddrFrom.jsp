<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/addStudentAddr.jjdev" method="post">
		<!------------------------ 오류있음--------------------------->
			<h3>주소추가</h3>
			<input type="hidden" name="studentNo" value="${studentNo}">
			<input type="text" name="address" placeholder="주소를 입력하세요.">
			<button type="submit">추가버튼</button>
		</form>
	</body>
</html>