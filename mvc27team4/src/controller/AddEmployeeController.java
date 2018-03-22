/* [mvc27team4] 이준희 */ 
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import model.EmployeeDao;

@WebServlet("/addEmployee.jjdev")
public class AddEmployeeController extends HttpServlet {
	private EmployeeDao employeedao;
	
	/**
	 * 	우리는 처음 화면에 직원 정보를 입력하기 위한 Form 화면을 띄우고 싶다. 따라서
	 *	처음 직원 입력폼 창을 호출하기 위해 request와 절대경로로 입력폼이 있는 곳으로 forward로 호출합니다.
	 *	forward로 호출한 이유는? : 처음 시작한 화면으로 아무입력값이도 없다. doPost에서 시작할려면 어느 특정한 Form에서 넘어 오는 입력값이 있으면 
	 *	메서드가 실행되는데에 비해 doGet 메서드는 ... get방식으로 주소를 넘겨서 불러오기 때문이다. 	
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/views/employee/addEmployee.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddrList.jsp").forward(request, response);
		//request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeAddrDeletForm.jsp").forward(request, response);
	}
	
	/**
	 * addEmployee.jsp에 있는 Form에서 입력값이 넘어 왔다. 
	 * 넘어온 값이 .jsp에서 넘어왔기에 우리는 폼에 있는 각 해당하는 name에 이름으로 getParameter(.jsp에서 폼으로 넘어온값은 대부분 이렇게 값을 받는듯 하다.)로 값을 받아서 String 변수에 담았다. 
	 * 생성자 메서드로 객체를 생성하고 참조값을 받은 employee가 Employee클래스에 있는 값을 받아온 값으로 setting 합니다. 
	 * setting된 참조값을 다시  생성자 메서드로 다른 객체를 생성하고 참조값을 받은곳에서 메서드에 인수값으로 setting된 참조값을 입력합니다.
	 * 그렇게 처리된값을 다른 화면으로 넘기기위해서 이번에 redirect로 넘겼다. 
	 * redirect로 호출한 이유? : 우리는 값을 입력받고 처리한 결과값에 따라서 새로운 화면을 보여주고 싶다. forward는 화면만 이동시키고 같은 객체를 공유한다면, 
	 * redirect는 새로운 객체를 생성하고 새로운 화면을 보여주게 된다.  
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=============insert doPost =====================");
		request.setCharacterEncoding("UTF-8");
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		String employeePwCheck = request.getParameter("employeePwCheck");
		
		Employee employee = new Employee();	
		employee.setEmployeeId(employeeId);
		employee.setEmployeePw(employeePw);
		
		this.employeedao = new EmployeeDao();
		employeedao.insertEmployee(employee);
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");			
	}

}
