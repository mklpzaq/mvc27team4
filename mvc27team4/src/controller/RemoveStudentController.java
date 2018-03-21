/*[mvc27team4] 방민영*/
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDao;


@WebServlet("/removeStudent.jjdev")
public class RemoveStudentController extends HttpServlet {
	private StudentDao studentDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		studentDao = new StudentDao();
		studentDao.deleteStudent(Integer.parseInt(studentNo));
		response.sendRedirect(request.getContextPath()+"/getStudentList.jjdev");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
