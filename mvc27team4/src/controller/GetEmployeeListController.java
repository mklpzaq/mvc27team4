/* [mvc27team4] 이준희 */
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;


@WebServlet("/GetEmployeeList.jjdev")
public class GetEmployeeListController extends HttpServlet {   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request..
		// EmployeeDao
		// request�� �Ӽ��߰�
		// forward
		EmployeeDao edao = new EmployeeDao();
		ArrayList<Employee> list = edao.selectEmployee();
		request.setAttribute("selectemployee", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeelist.jsp").forward(request, response);
		
	}

}
