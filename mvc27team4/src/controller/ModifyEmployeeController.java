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
	 * ��Ȳ: ���� ����Ʈ ȭ�鿡�� ������ư�� �������� get ������� �Ѱ����� doGet���� �޾Ƽ� ó���Ѵ�. 
	 * 		doGet���� ����ȭ������ �ѱ�� �ȴ�. 
	 * 		����Ʈ���� No���� �޾����� ���� ���� ����ȭ�鿡 �Ѱ� ����ȭ�鿡 ��´�. 
	 * 		No���� �������� id, pw,�� �����Ѵ�. 
	 */
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===GET ����ó������===");
		String send_nom = request.getParameter("send_Nom");
		System.out.println(send_nom + "<-- send_nom ");
		
		
	}	
}
