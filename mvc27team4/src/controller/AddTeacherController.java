// [mvc27team4] ���Ḳ
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addTeacher.jjdev")
public class AddTeacherController extends HttpServlet {
	
	/*private StudentDao studentDao;*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/teacher/addTeacher.jsp").forward(request, response);
	}
	
	// guest�Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request ó��
		//2. ��(DAO) ȣ��
		//3. list redirect
		
		String teacherId = request.getParameter("guestId");
		String teacherPw = request.getParameter("teacherPw");
		
		/*Teacher teahcer = new Teacher();
		TeacherDao teacherDao = new TeacherDao();
		teacherDao.insertGuest(Guest);*/
		
		//���� �䰡 �����Ƿ� ����Ʈ���� ���û�ϰڴ�.
		//�並 ������ �����̷�Ʈ
		response.sendRedirect("/getTeacherList.jjdev");
	}

}
