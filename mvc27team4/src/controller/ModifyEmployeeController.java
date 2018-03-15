/* [mvc27team4] 이준희 */ 
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

@WebServlet("/ModifyEmployee.jjdev")
public class ModifyEmployeeController extends HttpServlet {	       
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("===ModifyEmployeeController / doGet ===");
		String send_nom = request.getParameter("send_Nom");
		int send_Nom = Integer.parseInt(send_nom);
		System.out.println(send_nom + "<-- send_nom ");
		
		EmployeeDao edao = new EmployeeDao();
		Employee employee = edao.updateEmployeeOne(send_Nom);
		System.out.println("employee : " + employee);
		
		request.setAttribute("oneEmployee", employee);		
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeUpdateForm.jsp").forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===ModifyEmployeeController / doPost ===");
		
		String employeeno = request.getParameter("EmployeeNo");
		int EmployeeNo = Integer.parseInt(employeeno);
		String employeeid = request.getParameter("EmployeeId");
		String employeepw = request.getParameter("EmployeePw");
		System.out.println("EmployeeNo : " + EmployeeNo);
		System.out.println("employeeid : " + employeeid);
		System.out.println("employeepw : " + employeepw);
		
		Employee employee = new Employee();
		employee.setEmployeeNom(EmployeeNo);
		employee.setEmployeeId(employeeid);
		employee.setEmployeePw(employeepw);
		
		System.out.println("===============");
		
		EmployeeDao edao = new EmployeeDao();
		
		edao.updateEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/GetEmployeeList.jjdev");		
	}
}
