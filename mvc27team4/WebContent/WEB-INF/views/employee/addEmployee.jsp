<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		p{			
			color: red;
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>add Employee</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- 입력양식:	1.커서가 조건을 충족하지 못하고 벗어 났을때 밑에 빨간 글씨체로 오류 메세지를 보이게 하고 싶다. 
			 	2.커서가 조건을 충족했고 커서가 벗어 났을때 초록 글씨체로 확인 메세지를 보이게 하고 싶다. 
		 		3.버튼을 눌렀을때 조건이 충족하지 못하면 못한곳에 커서를 옴기고 버튼 박스 쪽에 빨간 글씨로 오류메세지를 띄운다. 
				4.버튼을 눌렀을때 조건이 충족되면 submit으로 값을 넘긴다.
			  
			상황1: 마우스로 벗어 나게 할 수도 있고 키보드로 벗어나게 할 수도 있다. 
			상황2: 글씨체들은 각 해당하는 div 에 너놓고 숨겨논 다음에 상황1이 발생할때 보이게 한다.
			상황3: 상황1,상황2가 조건을 만족하고 버튼을 클릭시 조건에 해당되게 진행한다.  -->
		
		<script>
		/* 	$(document).ready(function(){
				$("p").hide();
				$("input.employeeId").blur(function(){
					if($("input.employeeId").val().length <= 3) {
						$("p.employeeId_error").show();
					}else {
						
					}
				
				});			
				
			});		 */
		
			$(document).ready(function(){
				$("#btn").click(function(){
					if($("input.employeeId").val().length <= 3) {
						alert("아이디를 3자 이상입력하세요!");						
						$("input.employeeId").focus();						
					}else if($("input.employeePw").val().length <= 3) {
						alert("패스워드를 3자 이상입력하세요!")						
						$("input.employeeId").focus();
					}else if($("input.employeePwCheck").val() !== $("input.employeePw").val()) {
						alert("패스워드를 확인하세요");						
						$("input.employeeId").focus();
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
	<h1 style="text-align: center;">Employee Insert</h1>			
		<div class="col-md-4"></div>
		<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/addEmployee.jjdev" id="insertEmployee">
			  <div class="form-group">
			    <label for="exampleInputName2" class="control-label">employee_id</label>
			    <input type="text" class="employeeId" placeholder="employeeId" name="employeeId">
			  	<p class="employeeId_error">아이디는 3자 이상입니다.</p> 
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword2" class="col-sm-5 control-label">employee_pw</label>
			    <input type="password" class="employeePw" placeholder="employeePw" name="employeePw">
			 	<p class="employeePw_error">패스워드는 3자 이상입니다.</p>
			  </div>
			   <div class="form-group">
			    <label for="exampleInputPassword2" class="col-sm-5 control-label">employee_pw확인</label>
			    <input type="password" class="employeePwCheck" placeholder="employeePwCheck" name="employeePwCheck">
			 	<p class="employeePwCheck_error">패스워드가 일치하지 않습니다.</p>
			  </div>
			  <div class="form-group" style="text-align: center;">
			  <div>
			  <button type="button" class="btn btn-default" id="btn">직원추가</button>	
			  	<p class="btn-default_error">패스워드가 일치하지 않습니다.</p>
			  </div>	
			  </div>  
		</form>
		<div class="col-md-4"></div>	
</body>
</html>