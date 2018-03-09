<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			//�� ��ȿ�� �˻� �� ���� submit
			$("#insertTeacherBtn").click(function(){
				
				if( $("#teacherId").val().length < 2 ){
					$("#helper").text("2�� �̻� �Է����ּ���.");
				}else if( $("#teacherPw").val() === "" ){
					$("#helper").text("��й�ȣ�� �Է��Ͽ� �ֽʽÿ�.");
				}else if( $("#teacherPwCheck").val() !== $("#teacherPw").val() ){
					$("#helper").text("Ȯ�� ��й�ȣ�� ��Ȯ�� �Է����ּ���.");
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
			<form  method = "get" class="form-horizontal" id = "insertTeacherForm" action = "<%= request.getContextPath() %>/addTeacher.jjdev">
				<h1>addTeacher</h1>
				<div class="form-group">
					<label for="teacherId" class="col-sm-2 control-label">teacher_id</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="teacherId" placeholder="ID">
					</div>
				</div>
				
				<div class="form-group">
					<label for="teacherPw" class="col-sm-2 control-label">teacher_pw</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="teacherPw" placeholder="PW">
					</div>
				</div>
				
				<div class="form-group">
					<label for="teacherPwCheck" class="col-sm-2 control-label">teacher_pw Ȯ��</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="teacherPwCheck" placeholder="PW CHECK">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default" id = "insertTeacherBtn">teacher �߰�</button>
					</div>
				</div>
				<span id = "helper"></span>
			</form>
		</div>
		<div class = "col-sm-4"></div>
	</div>
</body>
</html>