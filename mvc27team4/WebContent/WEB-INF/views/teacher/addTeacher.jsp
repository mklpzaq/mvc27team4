<!-- [mvc27team4] 이춘림 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style>
		h1{text-align: center;}
	</style>
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
	<div class = "row">
		<div class = "col-sm-4"></div>
		<div class = "col-sm-4">
			<form  method = "post" class="form-horizontal" id = "insertTeacherForm" action = "<%= request.getContextPath() %>/addTeacher.jjdev">
				<h1>addTeacher</h1>
				<div class="form-group">
					<label for="teacherId" class="col-sm-2 control-label">teacher_id</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="teacherId" name = "teacherId" placeholder="ID">
					</div>
				</div>
				
				<div class="form-group">
					<label for="teacherPw" class="col-sm-2 control-label">teacher_pw</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="teacherPw" name = "teacherPw" placeholder="PW">
					</div>
				</div>
				
				<div class="form-group">
					<label for="teacherPwCheck" class="col-sm-2 control-label">teacher_pw 확인</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="teacherPwCheck" name = "teacherPwCheck" placeholder="PW CHECK">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default" id = "insertTeacherBtn">teacher 추가</button>
					</div>
				</div>
				<span id = "helper"></span>
			</form>
		</div>
		<div class = "col-sm-4"></div>
	</div>
</body>
</html>