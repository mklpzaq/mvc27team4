/* [mvc27team4] 이춘림 */
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
		System.out.println("doGet ModifyTeacherController");
		String tempString = request.getParameter("teacherNo");
		int teacherNo = Integer.parseInt(tempString);
		
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.updateTeacherOne(teacherNo);
		System.out.println(teacher + "<-- teacher");
		
		request.setAttribute("oneTeacher", teacher);
		request.getRequestDispatcher("/WEB-INF/views/teacher/modifyTeacherForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("doPost ModifyTeacherController");
		String tempString = request.getParameter("teacherNo");
		int teacherNo = Integer.parseInt(tempString);
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		System.out.println(teacherNo + "<--teacherNo");
		System.out.println(teacherId + "<--teacherId");
		System.out.println(teacherPw + "<--teacherPw");
		
		Teacher teacher = new Teacher();
		teacher.setTeacherNo(teacherNo);
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.updateTeacher(teacher);
		
		response.sendRedirect(request.getContextPath() + "/getTeacherList.jjdev");
	}

}



















