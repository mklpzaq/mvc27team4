/* [mvc27team4] 방민영 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;


@WebServlet("/getStudentList.jjdev")
public class GetStudentListController extends HttpServlet {
	Student student = new Student();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UFT-8");
		//request...
		//StudentDao
		//request에 속성 추가
		//forward
		request.getParameter("");
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
	}

}
