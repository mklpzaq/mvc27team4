/*[mvc27team4] 방민영*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addStudentAddr.jjdev")
public class AddStudentAddrController extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메소드확인 AddStudentAddrController.java 01");
		//18~19라인은 꼭필요한지 의문.(아직모르겠음)
		String studentNoTemp = request.getParameter("studentNo");
		int studentNo = Integer.parseInt(studentNoTemp);
		System.out.println(studentNo+"<<studentNo AddStudentAddrController.java 02");
		//GetStudentAddrListController에서 request.setAttribute("studentNo", studentNo);했기때문에 request세팅없이 forward한다.
		request.getRequestDispatcher("WEB-INF/views/student/addStudentAddrFrom.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 넘어왔음. AddStudentAddrController.java 03");
		String address = request.getParameter("address");
		System.out.println(address+"<<address AddStudentAddrController.java 04");
	}

}
