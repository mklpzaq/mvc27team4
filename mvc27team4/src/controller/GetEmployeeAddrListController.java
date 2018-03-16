package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;


@WebServlet("/getEmployeeAddrList.jjdev")
public class GetEmployeeAddrListController extends HttpServlet {       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetEmployeeAddrListController / doGet");
		String temp = request.getParameter("send_Nom");
		int employeeNo = Integer.parseInt(temp);
		System.out.println("employeeNo : " + employeeNo);
		
		EmployeeAddrDao adao = new EmployeeAddrDao();
		ArrayList<EmployeeAddr> list = adao.selectEmployeeAddr(employeeNo);
		System.out.println("GetEmployeeAddrListController / list : " + list);
		request.setAttribute("addrlist", list);	
		request.setAttribute("employeeNo", employeeNo);
	
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddrList.jsp").forward(request, response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
}
