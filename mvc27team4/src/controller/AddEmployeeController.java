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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("guestPw");
		Employee employee = new Employee();
			// guest setter »£√‚
		
		EmployeeDao employeedao = new EmployeeDao();
		employeedao.insertEmployee(employee);
		response.sendRedirect("/GetEmployeeList.jjdev");			
	}

}
