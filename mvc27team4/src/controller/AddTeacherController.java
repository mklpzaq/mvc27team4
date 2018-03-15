/* [mvc27team4] 이춘림 */
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
		//DB접근하는 메서드가 있는 .java파일에서 setCharacterEncoding을 UTF-8로 설정하면 DB인서트에 한글이 된다.
		request.setCharacterEncoding("UTF-8");
		String teacherId = request.getParameter("teacherId");
		String teacherPw = request.getParameter("teacherPw");
		
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherPw(teacherPw);
		
		this.teacherDao = new TeacherDao();
		this.teacherDao.insertTeacher(teacher);
		
		//나는 뷰가 없으므로 리스트쪽을 재용청하겠다.
		//뷰를 가진것으로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/getTeacherList.jjdev");
	}

}
