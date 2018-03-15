package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/ModifyStudentController")
public class ModifyStudentController extends HttpServlet {
	private StudentDao studentDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		studentDao = new StudentDao();
		String studentNo = request.getParameter("studentNo");
		Student student = studentDao.updateStudentOne(Integer.parseInt(studentNo));
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/views/student/modifyStudentForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int result = studentDao.updateStudent(student);
	}
}
