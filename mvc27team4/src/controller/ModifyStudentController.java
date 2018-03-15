package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

/**
 * Servlet implementation class ModifyStudentController
 */
@WebServlet("/ModifyStudentController")
public class ModifyStudentController extends HttpServlet {
	private StudentDao studentDao;
       
	public ModifyStudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		studentDao = new StudentDao();
		String studentNo = request.getParameter("studentNo");
		Student student = new Student();
		student.setStudentNo(Integer.parseInt(studentNo));
		studentDao.updateStudent(student);
	}

}
