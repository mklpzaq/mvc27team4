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
							System.out.println("==getEmployeeAddrList.jsp==");
							ArrayList<EmployeeAddr> list = (ArrayList<EmployeeAddr>)request.getAttribute("addrlist");
							int employeeNo = (int)request.getAttribute("employeeNo");
							System.out.println("employeeNo :" + employeeNo);					
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
		<button id="insertAddrButton" type="button"><a href="<%= request.getContextPath()%>/addEmployeeAddr.jjdev?employeeNo=<%= employeeNo%>">주소추가</a></button>
			</form>
		</div>	
		
	</body>
</html>