<!-- [mvc27team4] 이춘림 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>회원 가입</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<style>
			.control-label{margin:8px;}
		</style>
		<script>
			$(document).ready(function(){
				//폼 유효성 검사 후 폼을 submit
				$("#insertButton").click(function(){
					
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
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h3 class="text-center">회원가입</h3><hr>
					<form id="insertTeacherForm" method="post" action="<%= request.getContextPath() %>/addTeacher.jjdev">
						<div class="form-group">
							<label class="control-label" for="teacherId"><strong>아이디</strong></label>
							<div class="has-error">
								<input class="form-control" id="teacherId" type="text" name="teacherId" placeholder="아이디">
							</div>
							<label class="control-label" for="teacherPw"><strong>비밀번호</strong></label>
							<div>
								<input class="form-control" id="teacherPw" type="password" name="teacherPw" placeholder="비밀번호">
							</div>
							
							<label class="control-label" for="teacherPwCheck"><strong>비밀번호 확인</strong></label>
							<div>
								<input class="form-control" id="teacherPwCheck" type="password" name="teacherPwCheck" placeholder="비밀번호 확인">
							</div>
						</div>
						<div>
							<button class="btn-lg btn-block btn-primary " id="insertButton" type="button">입력 완료</button>
						</div>
					</form>
					<span id="helper"></span>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</div>
	</body>		
</html>