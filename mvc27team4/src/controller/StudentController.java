package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addStudent")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//student�Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/addStudent.jsp").forward(request, response);
	}

	//student�Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request.ó��
		//2.��(DAO) ȣ��
		//3.redirect(�ٸ� controllerȣ��)
	}

}
