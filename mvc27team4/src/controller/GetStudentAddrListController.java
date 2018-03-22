/* [mvc27team4] 방민영 */
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAddr;
import model.StudentAddrDao;


@WebServlet("/getStudentAddrList.jjdev")
public class GetStudentAddrListController extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get방식으로 GetStudentAddrListController.java로 넘어왔음.");
		StudentAddrDao studentAddrDao = new StudentAddrDao();
		String studentNoTemp = request.getParameter("studentNo");
		System.out.println("studentNoTemp : " + studentNoTemp + " ======================");
		int studentNo = Integer.parseInt(studentNoTemp);
		System.out.println(studentNo+"<<studentNo GetStudentAddrListController.java1");
		ArrayList<StudentAddr> list = studentAddrDao.selectStudentAddr(studentNo);
		request.setAttribute("studentNo", studentNo);
		request.setAttribute("studentAddr", list);
		System.out.println(list+"<<list GetStudentAddrListController.java2");
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentAddrList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
