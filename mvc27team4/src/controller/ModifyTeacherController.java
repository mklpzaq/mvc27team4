package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TeacherDao;
import model.Teacher;

@WebServlet("/modifyTeacher.jjdev")
public class ModifyTeacherController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("doget ModifyTeacherController");
		String tempString = request.getParameter("teacherNo");
		int teacherNo = Integer.parseInt(tempString);
		
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.updateTeacherOne(teacherNo);
		System.out.println(teacher + "<-- teacher");
		
		request.setAttribute("oneTeacher", teacher);
		request.getRequestDispatcher("/WEB-INF/views/teacher/modifyTeacherForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
