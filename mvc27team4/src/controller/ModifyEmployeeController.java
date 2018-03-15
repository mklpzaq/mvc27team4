package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyEmployee.jjdev")
public class ModifyEmployeeController extends HttpServlet {	       
	/**
	 * 상황: 직원 리스트 화면에서 수정버튼을 눌렀을때 get 방식으로 넘겼으니 doGet에서 받아서 처리한다. 
	 * 		doGet에서 수정화면으로 넘기게 된다. 
	 * 		리스트에서 No값을 받았으니 받은 값을 수정화면에 넘겨 수정화면에 담는다. 
	 * 		No값을 기준으로 id, pw,를 수정한다. 
	 */
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===GET 수정처리과정===");
		String send_nom = request.getParameter("send_Nom");
		System.out.println(send_nom + "<-- send_nom ");
		
		
	}	
}
