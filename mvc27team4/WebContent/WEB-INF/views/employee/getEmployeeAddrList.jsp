<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.EmployeeAddr" %>
<!DOCTYPE html>
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title></title>
	</head>
	<body>
	
		<div class="bs-example" data-example-id="simple-table">
			<button id="insertAddrButton">주소추가</button>
			<form action="" method="post">
				<table class="table">
				<caption>Optional table caption.</caption>
					<thead>
						<tr>
							<th>employee_addr_no</th>
							<th>employee_no</th>
							<th>address</th>						
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<EmployeeAddr> list = (ArrayList<EmployeeAddr>)request.getAttribute("addrlist");
							System.out.println("getEmployeeAddrList.jsp/ list : " + list);
							for(EmployeeAddr employeeAddr : list) {
						%>
						
						<tr>
							<th scope="row"><%= employeeAddr.getEmployeeAddrNo()%></th>
							<td><%= employeeAddr.getEmployeeNo()%></td>
							<td><%= employeeAddr.getAddress()%></td>						
						</tr>
						<%
						}
						%>
											
					</tbody>
				</table>
			</form>
		</div>	
		
	</body>
</html>