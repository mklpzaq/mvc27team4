/* [mvc27team4] 이춘림 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherDao;

@WebServlet("/removeTeacher.jjdev")
public class RemoveTeacherController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveTeacherController / doGet");
		String temp = request.getParameter("teacherNo");
		int teacherNo = Integer.parseInt(temp);
		System.out.println("teacherNo : " + teacherNo);
		
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.deleteTeacher(teacherNo);
		
		response.sendRedirect(request.getContextPath() + "/getTeacherList.jjdev");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
