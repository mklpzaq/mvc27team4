package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ksmart.dao.EmployeeDao;
import kr.or.ksmart.dto.Employee;

@WebServlet("/addEmployee.jjdev")
public class EmployeeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			System.out.println(request + "<----------");
			System.out.println(response + "<---------");
			Employee emplo = new Employee();
			String employeeId = request.getParameter("employeeId");
			String employeePw = request.getParameter("employeePw");
			
			emplo.setEmployeeId(employeeId);
			emplo.setEmployeePw(employeePw);
			
			EmployeeDao dao = new EmployeeDao();		
			dao.insertEmployee(emplo);
		
		
	}

}
