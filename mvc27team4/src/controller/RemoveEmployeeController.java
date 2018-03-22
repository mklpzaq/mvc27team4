package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDao;


@WebServlet("/removeEmployee.jjdev")
public class RemoveEmployeeController extends HttpServlet {
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveEmployeeController 실행");
		String temp = request.getParameter("send_Nom");
		int send_num = Integer.parseInt(temp);
		
		EmployeeDao edao = new EmployeeDao();
		edao.deleteEmployee(send_num);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
