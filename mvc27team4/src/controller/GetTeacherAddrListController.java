package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeacherAddrDao;
import java.util.ArrayList;
import model.TeacherAddr;

@WebServlet("/getTeacherAddrList.jjdev")
public class GetTeacherAddrListController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetTeacherAddrListController / doGet");
		String temp = request.getParameter("teacherNo");
		int teacherNo = Integer.parseInt(temp);
		System.out.println("teacherNo : " + teacherNo);
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		ArrayList<TeacherAddr> list = teacherAddrDao.selectTeacherAddr(teacherNo);
		System.out.println("list : " + list);
		request.setAttribute("teacherAddrList", list);
		request.setAttribute("teacherNo", teacherNo);
		
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherAddrList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
