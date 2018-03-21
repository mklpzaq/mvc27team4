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
