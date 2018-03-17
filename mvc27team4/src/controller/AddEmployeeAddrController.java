/* [mvc27team4] 이준희 */ 
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;

@WebServlet("/addEmployeeAddr.jjdev")
public class AddEmployeeAddrController extends HttpServlet {
	/**
	 * get방식으로 직원의 넘버 값을 받았다. 
	 * 그 직원에 해당하는 주소를 입력하고 싶다. 
	 * 주소입력Form의 화면을 보여주기 위해 forward로 화면을 이동시킨다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== AddEmployeeAddrController / doGet ===");
		String temp = request.getParameter("employeeNo");
		System.out.println("=========" + temp);
		int employeeNo = Integer.parseInt(temp);
		System.out.println("employeeNo :" + employeeNo);
		
		request.getRequestDispatcher("WEB-INF/views/employee/addEmployeeAddrForm.jsp").forward(request, response);
	}
	
	/**
	 * 주소입력창에서 값을 받아온다. 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("==AddEmployeeAddrController / doPost==");
		 String address = request.getParameter("address");
		 System.out.println("address :" + address);
	}

}
