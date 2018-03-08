<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		#employeeId {
			background-color: white;
			color: black;
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>add Employee</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#btn").click(function(){
					if($("#employeeId").val().length <= 3) {
						alert("아이디를 3자 이상입력하세요!");
						$("#employeeId").css("background-color", "red");
						$("#employeeId").focus();						
					}else if($("#employeePw").val().length <= 3) {
						alert("패스워드를 3자 이상입력하세요!")
						$("#employeeId").css("background-color", "red");
						$("#employeePw").focus();
					}else if($("#employeePwCheck").val() !== $("#employeePw").val()) {
						alert("패스워드를 확인하세요");
						$("#employeeId").css("background-color", "red");
						$("#employeePwCheck").focus();
					}else {
						alert("입력완료");
						$("#insertEmployee").submit();
					}
				});
				
			});	
		</script>		
</head>
<body>
	<br>
	<br>
	<form class="form-inline" method="post" href="<%=request.getContextPath()%>/addEmployee.jjdev" id="insertEmployee">
		  <div class="form-group">
		    <label for="exampleInputName2">employee_id</label>
		    <input type="text" class="form-control" id="employeeId" placeholder="employeeId" name="employeeId">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail2">employee_pw</label>
		    <input type="email" class="form-control" id="employeePw" placeholder="employeePw" name="employeePw">
		  </div>
		   <div class="form-group">
		    <label for="exampleInputEmail2">employee_pw확인</label>
		    <input type="email" class="form-control" id="employeePwCheck" placeholder="employeePwCheck" name="employeePwCheck">
		  </div>
		  <button type="button" class="btn btn-default" id="btn">직원추가</button>
	</form>
</body>
</html>