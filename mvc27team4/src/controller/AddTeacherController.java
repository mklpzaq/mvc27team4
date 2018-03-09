// [mvc27team4] 이춘림
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addTeacher.jjdev")
public class AddTeacherController extends HttpServlet {
	
	/*private StudentDao studentDao;*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacher.jsp").forward(request, response);
	}
	
	// guest입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request 처리
		//2. 모델(DAO) 호출
		//3. list redirect
		
		String teacherId = request.getParameter("guestId");
		String teacherPw = request.getParameter("teacherPw");
		
		/*Teacher teahcer = new Teacher();
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.insertGuest(Guest);*/
		
		//나는 뷰가 없으므로 리스트쪽을 재용청하겠다.
		//뷰를 가진것 리다이렉트
		response.sendRedirect("/getTeacherList.jjdev");
	}

}
