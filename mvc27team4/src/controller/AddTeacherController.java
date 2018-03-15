/* [mvc27team4] ���Ḳ */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import model.TeacherDao;


@WebServlet("/addTeacher.jjdev")
public class AddTeacherController extends HttpServlet {
	
	private TeacherDao teacherDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacher.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB�����ϴ� �޼��尡 �ִ� .java���Ͽ��� setCharacterEncoding�� UTF-8�� �����ϸ� DB�μ�Ʈ�� �ѱ��� �ȴ�.
		request.setCharacterEncoding("UTF-8");
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		
		this.teacherDao = new TeacherDao();
		this.teacherDao.insertTeacher(teacher);
		
		//���� �䰡 �����Ƿ� ����Ʈ���� ���û�ϰڴ�.
		//�並 ���������� �����̷�Ʈ
		response.sendRedirect(request.getContextPath() + "/getTeacherList.jjdev");
	}

}
