package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;

@WebServlet("/addEmployeeAddr.jjdev")
public class AddEmployeeAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== AddEmployeeAddrController / doGet ===");
		String temp = request.getParameter("employeeNo");
		System.out.println("=========" + temp);
		int employeeNo = Integer.parseInt(temp);
		System.out.println("employeeNo :" + employeeNo);
		
		request.getRequestDispatcher("WEB-INF/views/employee/addEmployeeAddrForm.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("==AddEmployeeAddrController / doPost==");
		 String address = request.getParameter("address");
		 System.out.println("address :" + address);
	}

}
