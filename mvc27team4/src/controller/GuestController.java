package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addGuest.jjdev")
public class GuestController extends HttpServlet {
	// guest 입력 폼요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.getRequestDispatcher("/WEB-INF/views/addGuest.jsp").forward(request, response);
	}

	// guest 입력
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request 처리
		//2. 모델(DAO) 호출
		//3. 다른 controller 호출 : redirect
		
		
	}

}
