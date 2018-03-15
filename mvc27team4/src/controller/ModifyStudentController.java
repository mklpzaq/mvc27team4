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

@WebServlet("/modifyStudent.jjdev")
public class ModifyStudentController extends HttpServlet {
	private StudentDao studentDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		studentDao = new StudentDao();
		String studentNoTemp = request.getParameter("studentNo");
		int studentNo = Integer.parseInt(studentNoTemp);
		Student student = studentDao.updateStudentOne(studentNo);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/views/student/modifyStudentForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String studentNo = request.getParameter("studentNo");
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		Student student = new Student();
		student.setStudentNo(Integer.parseInt(studentNo));
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		studentDao = new StudentDao();
		studentDao.updateStudent(student);
	}
}
