package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;

@WebServlet("/removeEmployeeAddr.jjdev")
public class RemoveEmployeeAddrController extends HttpServlet {
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet RemoveEmployeeAddrController.java");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost RemoveEmployeeAddrController.java");
		
		String employeeNo = request.getParameter("employeeNo");
		String[] employeeAddrNoArr = request.getParameterValues("deleteAddrCheck");
		System.out.println("employeeNo : " + employeeNo);
		if(employeeAddrNoArr != null) {
			for(String str : employeeAddrNoArr) {
				System.out.println(str + "<---employeeAddrNoArr.str");
			}
		}else {
			System.out.println("employeeAddrNoArr : " + employeeAddrNoArr);
		}
		
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.deleteEmployeeAddr(employeeAddrNoArr);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeAddrList.jjdev?employeeNo=" + employeeNo);
	}

}
