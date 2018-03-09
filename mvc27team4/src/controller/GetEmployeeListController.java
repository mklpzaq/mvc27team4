package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetEmployeeList.jjdev")
public class GetEmployeeListController extends HttpServlet {   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request..
		// EmployeeDao
		// request에 속성추가
		// forward
		
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeelist.jsp").forward(request, response);
		
	}

}
