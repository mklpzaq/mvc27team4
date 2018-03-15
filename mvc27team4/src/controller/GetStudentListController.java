/*[mvc27team4] 방민영*/
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/getStudentList.jjdev")
public class GetStudentListController extends HttpServlet {
	
	private StudentDao studentDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetStudentListController / doGet");
		//request.setCharacterEncoding("UTF-8");
		
		
		studentDao = new StudentDao();
		ArrayList<Student> list = studentDao.selectStudent();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
	}

}
