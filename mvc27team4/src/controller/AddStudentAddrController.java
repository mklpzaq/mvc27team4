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
		System.out.println("doGet AddStudentAddrController.java");
		
		request.setAttribute("studentNo", request.getParameter("studentNo"));
		System.out.println(request.getParameter("studentNo")+"<<request.getParameter(\"studentNo\") AddStudentAddrController.java");
		request.getRequestDispatcher("/WEB-INF/views/student/addStudentAddrForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 넘어왔음. AddStudentAddrController.java 03");
		String address = request.getParameter("address");
		System.out.println(address+"<<1address doPost메소드 AddStudentAddrController.java");
		String studentNoTemp = request.getParameter("studentNo");
		System.out.println(studentNoTemp+"<<2studentNoTemp doPost메소드 AddStudentAddrController.java");
		int studentNo = Integer.parseInt(studentNoTemp);
		System.out.println(studentNo+"<<3studentNo doPost메소드 AddStudentAddrController.java");
		
		StudentAddr studentAddr = new StudentAddr();
		studentAddr.setStudentNo(studentNo);
		studentAddr.setAddress(address);
		
		System.out.println(studentAddr.toString());
		System.out.println("========tostirng===========");
		StudentAddrDao addrDao = new StudentAddrDao();
		addrDao.insertStudentAddr(studentAddr);
		System.out.println(addrDao+"<<addrDao doPost메소드 AddStudentAddrController.java");
		response.sendRedirect(request.getContextPath()+"/getStudentAddrList.jjdev?studentNo="+studentNo);
		System.out.println("response후.. doPost메소드 AddStudentAddrController.java");

	}

}
