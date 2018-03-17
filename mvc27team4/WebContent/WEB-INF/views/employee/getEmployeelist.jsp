<!-- [mvc27team4] 이준희 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import= "model.Employee" %>
<%@ page import= "model.EmployeeDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
	<h1>Employee List</h1>
	<!-- 
		GetEmployeeListController 클래스에서 setAttribute로 담긴 list 값으로 
		회원전체 리스트를 보여주는 화면 입력창을 보여준다. 
		전체회원 이여서 반복문 for안에 테이블을 만들고 list에 담긴 회원 만큼 반복시킨다.
		또한 수정, 삭제 , 주소추가를 하기위해 get방식으로 직원에 해당하는 no값을 넘깁니다.		 
	 -->
	
	<%
		EmployeeDao employeedao = new EmployeeDao();
		ArrayList<Employee> list = (ArrayList<Employee>)request.getAttribute("selectemployee");
	%>
	<%
		for(Employee employee : list) {			
	%>
		<div class="bs-example" data-example-id="simple-table">
		 <table class="table">
		      <caption>Optional table caption.</caption>
		      <thead>
		        <tr>
		          <th>EMPLOYEE_NO</th>		        
		          <th>EMPLOYEE_Id</th>
		          <!-- <th>EMPLOYEE_Pw</th> -->
		          <th>수정</th> <!-- employeeDao.updateGuest() -->
		          <th>삭제</th> <!-- employeeDao.deleteGuest() -->	
		          <th>ADD EMPLOYEE_ADDR</th> <!-- employeeAddrDao.insertGuestAddr() -->
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
		          <th scope="row"><%= employee.getEmployeeNom() %></th>		        
		          <td><%= employee.getEmployeeId() %></td>
		          <td><a href="<%=request.getContextPath()%>/ModifyEmployee.jjdev?send_Nom=<%=employee.getEmployeeNom()%>">수정</a></td>
		          <td><a href="">삭제</a></td>
		          <td><a href="<%=request.getContextPath()%>/getEmployeeAddrList.jjdev?send_Nom=<%=employee.getEmployeeNom()%>">주소추가</a></td>		         
		        </tr>		       
	      </tbody>
	    </table>
	  </div>	
	
	<% 
	}
	%>
</body>
</html>