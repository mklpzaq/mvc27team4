/* [mvc27team4] 이준희 */ 
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
import model.EmployeeAddrDao;


@WebServlet("/getEmployeeAddrList.jjdev")
public class GetEmployeeAddrListController extends HttpServlet {       

	/**
	 * 전체리스트에서 주소추가를 누를시에 get방식으로 개인 한직원에 해당하는 넘버값을 넘겼다. 
	 * 우리는 직원한명에 해당하는 주소를 보고 싶다.
	 * 당연히 넘버값은 int형 숫자로 되어있고 jsp에서 넘긴값을 받을 때는 getParameter로 받아야되는데 String형 으로 받게 못받는다. 
	 * String형은 int형으로 바꿔주는 Integer.parseInt()메서드를 사용하여 int로 바꾼다. 
	 * new 연산자로 생성자를 만들고 참조값을 참조변수에 넘긴다.
	 * 리턴받은 값을 ArrayList<EmployeeAddr>의 list에 담고 
	 * setAttribute로 list와, employeeNo(직원넘버)값을 담아논다. 
	 * get으로 가져온 값을 그대로 화면만 이동시켜 보여주기 위해 forward를 사용하여 getEmployeeAddrList.jsp로  화면을 이동 시켰다. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetEmployeeAddrListController / doGet");
		request.setCharacterEncoding("UTF-8");
		String temp = request.getParameter("employeeNo");
		int employeeNo = Integer.parseInt(temp);
		System.out.println("employeeNo : " + employeeNo);
		
		EmployeeAddrDao adao = new EmployeeAddrDao();
		ArrayList<EmployeeAddr> list = adao.selectEmployeeAddr(employeeNo);
		System.out.println("GetEmployeeAddrListController / list : " + list);
		request.setAttribute("addrlist", list);	
		request.setAttribute("employeeNo", employeeNo);
	
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddrList.jsp").forward(request, response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
}
