/*[mvc27team4] 방민영*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;


@WebServlet("/addStudent.jjdev")
public class AddStudentController extends HttpServlet {
	private StudentDao studentDao;

	//addStudent.jsp 화면을 보여주기 위한 요청.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/student/addStudent.jsp").forward(request, response);
	}

	//addStudent.jsp에서 값들을 전달받아 insert메서드 작업을 실행함.
	//getStudentList로 sendRedirect함.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		System.out.println(studentId);
		System.out.println(studentPw);
		
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		this.studentDao = new StudentDao();
		
		studentDao.insertStudent(student);
		
		response.sendRedirect(request.getContextPath()+"/getStudentList.jjdev");
	}
}
