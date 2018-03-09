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
	//student�Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	//student�Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request.ó��
		//2.��(DAO) ȣ��
		//3.redirect(�ٸ� controllerȣ��)
		String studentId = request.getParameter("studentId");
		String studentPw = request.getParameter("studentPw");
		Student student = new Student();
		//student setter ȣ��
		this.studentDao = new StudentDao();
		studentDao.insertStudent(student);
		response.sendRedirect("/getStudentList");
	}

}
