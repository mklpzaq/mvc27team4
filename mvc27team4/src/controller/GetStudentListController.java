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
		System.out.println("GetStudentListController / doGet메소드 시작");
		request.setCharacterEncoding("UTF-8");
		
		int currentPage=1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println(currentPage+"<<currentPage doGet메소드 GetStudentListController.java");
		
		int pagePerRow=10;
		System.out.println(pagePerRow+"<<pagePerRow 1 doGet메소드 GetStudentListController.java");

		/*String pagePerRowTemp = (String)request.getParameter("pagePerRow");
		pagePerRow = Integer.parseInt(pagePerRowTemp);
		if(pagePerRow > 10) {
			//---------------------------추가하기---------------------------------------//
		}
		System.out.println(pagePerRow+"<<pagePerRow doGet메소드 GetStudentListController.java");*/
		
		int startRow=(currentPage-1)*pagePerRow;
		System.out.println(startRow+"<<startRow doGet메소드 GetStudentListController.java");
		
		studentDao = new StudentDao();
		ArrayList<Student> list = studentDao.selectStudent(startRow, pagePerRow);
		
		int totalRowCount = studentDao.studentRowCount();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0) {
			lastPage++;
		}
		System.out.println(lastPage+"<<========================lastPage doGet메소드 GetStudentListController.java");
		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
/*		request.setAttribute("pagePerRow", pagePerRow);
*/		request.setAttribute("lastPage", lastPage);
		request.getRequestDispatcher("/WEB-INF/views/student/getStudentList.jsp").forward(request, response);
		System.out.println("GetStudentListController / doGet메소드 끝");
	}
}
