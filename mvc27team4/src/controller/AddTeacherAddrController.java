/* [mvc27team4] 이춘림 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddr;
import model.TeacherAddrDao;

@WebServlet("/addTeacherAddr.jjdev")
public class AddTeacherAddrController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet AddTeacherAddrController.java");
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacherAddrForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost AddTeacherAddrController.java");
		request.setCharacterEncoding("UTF-8");
		String temp = request.getParameter("teacherNo");
		int teacherNo = Integer.parseInt(temp);
		String address = request.getParameter("address");
		System.out.println("teacherNo : " + teacherNo);
		System.out.println("address : " + address);
		
		TeacherAddr teacherAddr = new TeacherAddr();
		teacherAddr.setTeacherNo(teacherNo);
		teacherAddr.setAddress(address);
		TeacherAddrDao teacherAdderDao = new TeacherAddrDao();
		int result = teacherAdderDao.insertTeacherAddr(teacherAddr);
		System.out.println("result : " + result);
		/*
		 * insertTeacherAddr() 메서드의 리턴값이 2라는 의미는
		 * 해당 Teacher의 주소록의 개수가 5개가 초과되었다는 의미이다.
		 * 따라서 주소록 개수 5개 초과에 따른 적절한 경고창을 보여주도록 if문을 사용하였다.
		 * 
		 * out.println() 메서드를 통해 인터넷 창에 글자를 적어
		 * return ; (리턴 세미콜론)을 사용하면 새로운 html창이 뜨고 
		 * out.pirntln() 메서드 매개변수로 넣었던 String형 글자가 html형식으로 읽히게 된다.
		 * 그리고 경고창이 발생하고 확인을 누르면,
		 *  location.href='./getTeacherAddrList.jjdev' 로 설정하였던 URL로 이동하게 된다.
		 *  */
		if(result == 2) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('address 입력 갯수 5개를 초과하셨습니다.');");
			out.println("location.href='./getTeacherAddrList.jjdev?teacherNo=" + teacherNo + "';");
			out.println("</script>");
			out.close();
			return ;
		}
		response.sendRedirect(request.getContextPath() + "/getTeacherAddrList.jjdev?teacherNo=" + teacherNo);
	}
}
