package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentAddrDao;


@WebServlet("/removeStudentAddr.jjdev")
public class RemoveStudentAddrController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메소드 시작 RemoveStudentAddrController.java");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메소드 시작 RemoveStudentAddrController.java");
		String[] deleteAddrCheck = request.getParameterValues("deleteAddrCheck");
		String studentNo = request.getParameter("studentNo");
		System.out.println(deleteAddrCheck+"<<deleteAddrCheck RemoveStudentAddrController.java");
		System.out.println(studentNo+"<<studentNo RemoveStudentAddrController.java");
		if(deleteAddrCheck != null) {
			for(String addr : deleteAddrCheck) {
				System.out.println(addr+"<<addr RemoveStudentAddrController.java");
			}
		}else {
			System.out.println("아무것도 체크안함.");
		}
		StudentAddrDao addrDao = new StudentAddrDao();
		int result = addrDao.deleteStudentAddr(deleteAddrCheck);
		
		System.out.println("======deleteStudentAddr 수행후====RemoveStudentAddrController쪽 끝부분으로 나옴============");
		response.sendRedirect(request.getContextPath()+"/getStudentAddrList.jjdev?studentNo="+studentNo);
	}

}
