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
		          <td><a href="">주소추가</a></td>		         
		        </tr>		       
	      </tbody>
	    </table>
	  </div>	
	
	<% 
	}
	%>
</body>
</html>