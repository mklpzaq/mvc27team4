/* [mvc27team4] 이춘림 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;
import model.TeacherDao;
import java.util.ArrayList;

@WebServlet("/getTeacherList.jjdev")
public class GetTeacherListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet GetTeacherListController");
		request.setCharacterEncoding("UTF-8");
		
		//==================
		int pagePerRow = 10; //요청페이지에서 받을 수도 있습니다.
		int currentPage = 1; //처음에 1페이지로 정해져 있음.
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int startRow = (currentPage - 1)*pagePerRow;
		//==================
		
		
		
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<Teacher> list = teacherDao.selectTeacher(startRow, pagePerRow);
		System.out.println("list : " + list);
		request.setAttribute("selectTeacher", list);
	
		//=============
		int totalRowCount = teacherDao.teacherRowCount();
		System.out.println("totalRowCount : " + totalRowCount);
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount % pagePerRow != 0) {
			lastPage++;
		}
		System.out.println(lastPage + "<-- lastPage");
		/* double로 계산해서 소수점을 무조건 올리는 방버보 있다.*/
		
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		//==============
		
		
		request.getRequestDispatcher("/WEB-INF/views/teacher/getTeacherList.jsp").forward(request, response);
	}
}
