package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.StudentDao;
import kr.or.ksmart.dto.Student;


@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet {
	private StudentDao studentDao;
	//student입력 폼요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	//student입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request.처리
		//2.모델(DAO) 호출
		//3.redirect(다른 controller호출)
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		Student student = new Student();
		//student setter 호출
		this.studentDao = new StudentDao();
		studentDao.insertStudent(student);
		response.sendRedirect("/getStudentList");
	}

}
