<!-- [mvc27team4] 방민영 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>addStudent</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style>
		body{padding:0; margin: 0; background-color: #D4F4FA !important;}
		h1{text-align: center;}
		.panel{margin-bottom: 0 !important;}
		.footer{text-align: center; padding:15px}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#insertStudentBtn").click(function(){
				if($("#studentId").val().length<4){
					$("#helper").text("4자 이상 입력하세요.");
				}else if($("#studentPw").val()===""){
					$("#helper").text("비밀번호를 입력하세요.");
				}else if($("#studentPw").val().length<4){
					$("#helper").text("4자 이상 입력하세요.");
				}else if($("#studentPw").val()!==$("#studentPwCheck").val()){
					$("#helper").text("비밀번호를 정확히 입력하세요.");
				}else{
					$("#insertStudentForm").submit();
				}
			});
		});	
	</script>
</head>
<body>
	<h1>addStudent</h1>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-body form-horizontal">
				
					<!-- addStudent.jjdev로 입력받은 값을 post방식으로 전송. -->
					<form action="${pageContext.request.contextPath}/addStudent.jjdev" id="insertStudentForm" method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentId">student_id</label>
							<div class="col-sm-10">
								<input type="text" id="studentId" name="studentId" class="form-control" placeholder="새로운 아이디를 입력하세요.">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentPw">student_pw</label>
							<div class="col-sm-10">
								<input type="password" id="studentPw" name="studentPw" class="form-control" placeholder="비밀번호를 입력하세요.">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentPwCheck">student_pw확인</label>
							<div class="col-sm-10">
								<input type="password" id="studentPwCheck" name="studentPwCheck" class="form-control" placeholder="비밀번호를 입력하세요.">
							</div>
						</div>
						<button type="button" id="insertStudentBtn" class="btn btn-lg btn-primary btn-block">학생 추가</button>
						<span id="helper"></span>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>

	<div class="footer">
	</div>

</body>
</html>