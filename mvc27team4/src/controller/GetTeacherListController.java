// [mvc27team4] 이춘림
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

//요청이 들어오면,
@WebServlet("/getTeacherList.jjdev")
public class GetTeacherListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request....
		// GuestDao
		// request에 속성 추가
		// forward
		 
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<Teacher> list = teacherDao.selectTeacher();
		
		
		
		
		request.setAttribute("selectTeacher", list);
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherList.jsp").forward(request, response);
		
	}

}
