package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addGuest.jjdev")
public class GuestController extends HttpServlet {
	// guest �Է� ����û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.getRequestDispatcher("/WEB-INF/views/addGuest.jsp").forward(request, response);
	}

	// guest �Է�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request ó��
		//2. ��(DAO) ȣ��
		//3. �ٸ� controller ȣ�� : redirect
		
		
	}

}
