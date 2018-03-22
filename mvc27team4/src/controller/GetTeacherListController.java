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
import java.util.ArrayList;

@WebServlet("/getTeacherList.jjdev")
public class GetTeacherListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet GetTeacherListController");
		request.setCharacterEncoding("UTF-8");
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<Teacher> list = teacherDao.selectTeacher();
		System.out.println("list : " + list);
		
		request.setAttribute("selectTeacher", list);
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherList.jsp").forward(request, response);
	}
}
