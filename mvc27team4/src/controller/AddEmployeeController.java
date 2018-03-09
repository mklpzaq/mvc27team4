// [mvc27team4] ������
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Employee;
import service.EmployeeDao;

@WebServlet("/addEmployee.jjdev")
public class AddEmployeeController extends HttpServlet {
	EmployeeDao employeedao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/employee/addEmployee.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		String employeePwCheck = request.getParameter("employeePwCheck");
		
		Employee employee = new Employee();	
			employee.setEmployeeId(employeeId);
			employee.setEmployeePw(employeePw);
		
		employeedao = new EmployeeDao();
		employeedao.insertEmployee(employee);
		response.sendRedirect(request.getContextPath() + "/GetEmployeeList.jjdev");			
	}

}
