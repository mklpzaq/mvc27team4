<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<link href="<%= request.getContextPath() %>/teacher_bootstrap/assets/plugins/morris/morris-0.4.3.min.css" rel="stylesheet" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			//폼 유효성 검사 후 폼을 submit
			$("#insertTeacherBtn").click(function(){
				
				if( $("#teacherId").val().length < 2 ){
					$("#helper").text("2자 이상 입력해주세요.");
				}else if( $("#teacherPw").val() === "" ){
					$("#helper").text("비밀번호를 입력하여 주십시오.");
				}else if( $("#teacherPwCheck").val() !== $("#teacherPw").val() ){
					$("#helper").text("확인 비밀번호를 정확히 입력해주세요.");
				}else{
					$("#helper").text("");
					$("#insertTeacherForm").submit();
				}
				
			});
		});
	</script>
</head>
<body>
	<h1>addTeacher</h1>
	<form  method = "get" class="form-horizontal" id = "insertTeacherForm" action = "<%= request.getContextPath() %>/addTeacher.jjdev">
		<h1>addTeacher</h1>
		<div class="form-group">
			<label for="teacherId" class="col-sm-2 control-label">teacher_id : </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="teacherId" placeholder="ID">
			</div>
		</div>
		
		<div class="form-group">
			<label for="teacherPw" class="col-sm-2 control-label">teacher_pw :</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="teacherPw" placeholder="PW">
			</div>
		</div>
		
		<div class="form-group">
			<label for="teacherPwCheck" class="col-sm-2 control-label">teacher_pw 확인 : </label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="teacherPwCheck" placeholder="PW CHECK">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-default" id = "insertTeacherBtn">teacher 추가</button>
			</div>
		</div>
		<span id = "helper"></span>
	</form>
	
	
</body>
</html>