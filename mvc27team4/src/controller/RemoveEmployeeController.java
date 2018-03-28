package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;
import model.EmployeeDao;


@WebServlet("/removeEmployee.jjdev")
public class RemoveEmployeeController extends HttpServlet {
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveEmployeeController 실행");
		String temp = request.getParameter("employeeNo");
		int send_num = Integer.parseInt(temp);
		
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		int result = employeeAddrDao.countAddr(send_num);
		
		if(result > 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('address 입력 갯수 5개를 초과하셨습니다.');");
			out.println("location.href='./getEmployeeAddrList.jjdev?employeeNo=" + send_num + "';");
			out.println("</script>");
			out.close();
			return ;
		}else {
			EmployeeDao edao = new EmployeeDao();
			edao.deleteEmployee(send_num);
		}
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
