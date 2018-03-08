<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addGuest</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		//폼 유효성 검사 후 폼을 submit
		$("#insertGuestButton").click(function(){
			
			if( $("#guestId").val().length < 2 ){
				
			}
			
		});
	});
</script>
</head>
<body>
	<h1>addGuest</h1>
	<form id = "insertGuestForm" class="form-inline" action = "<%= request.getContextPath() %>/addGuest.jjdev">
		<div class="form-group">
			<label for="guestId">guest_id : </label>
			<input class="form-control" type="text" id="guestId" placeholder="ID">
		</div>
		<div class="form-group">
			<label for="guestPw">guest_pw : </label>
			<input class="form-control" type="password" id="guestPw" placeholder="PASSWORD">
		</div>
		<div class="form-group">
			<label for="guestPwCheck">guest_pw 확인 : </label>
			<input class="form-control" type="password" id="guestPwCheck" placeholder="PASSWORD2">
		</div>
			<button id = "insertGuestButton" type="button" class="btn btn-default">게스트 추가</button>
	</form>
		



<%-- 
	<h1>addGuest</h1>
	<form action = "<%= request.getContextPath() %>/addGuest.jjdev">
		guest_id : 
		<input type = "text" id = "guestId" class = "">
		guest_pw : 
		<input type = "password" id = "guestPw" class = "">
		guest_pw 확인 : 
		<input type = "password" id = "guestPwCheck" class = "">
		
		<button type = "button">게스트 추가</button>
	</form> --%>
</body>
</html>