/*[mvc27team4] 방민영*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;


@WebServlet("/addStudentAddr.jjdev")
public class AddStudentAddrController extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("studentNo", request.getParameter("studentNo"));
		System.out.println(request.getParameter("studentNo")+"<<request.getParameter(\"studentNo\") AddStudentAddrController.java");
		request.getRequestDispatcher("WEB-INF/views/student/addStudentAddrFrom.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 넘어왔음. AddStudentAddrController.java 03");
		String address = request.getParameter("address");
		String studentNoTemp = request.getParameter("studentNo");
		int studentNo = Integer.parseInt("studentNoTemp");
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentNo(studentNo);
		studentAddr.setAddress(address);
		StudentAddrDao addrDao = new StudentAddrDao();
		addrDao.insertStudentAddr(studentAddr);
		response.sendRedirect(request.getContextPath()+"/getStudentAddrList.jjdev");
		
		
	}

}
