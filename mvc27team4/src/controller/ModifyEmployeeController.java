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

@WebServlet("/ModifyEmployee.jjdev")
public class ModifyEmployeeController extends HttpServlet {	       
		
	/** 
	 * getEmployeelist.jsp의 테이블 에서 수정을 클릭시 회원이 가지고 있는 넘버를 넘긴값을 받아서 doget메서드 에서 그값을 처리합니다. 
	 * 우리는 회원넘버를 기준으로 id,pw를 수정하고 싶다.
	 * 데이더베이스에서 넘버값은 숫자형 int로 되어있다  getParameter는 String으로만 가져올 수 있어서
	 * 다시 int로 변환을 시켜줘야 한다. 그때에  Integer.parseInt메서드로 변환 시켜서 int형 변수에 값을 넣어 주면된다. 
	 * 다시 생성자로 객체를 생성하고 참조값을 받은 참조변수가 int로 변환한 값을 인수로 넣어서 메서드를 호출 한다. 
	 * 한명의 회원정보값을 받아왔다. 그값을 setAttribute에 담아 논다. 
	 * request, response의 객체를 그대로 사용하면서 화면만 이동시키기 위해 getEmployeeUpdateForm으로 forward 시켰다. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("===ModifyEmployeeController / doGet ===");
		String send_nom = request.getParameter("send_Nom");
		int send_Nom = Integer.parseInt(send_nom);
		System.out.println(send_nom + "<-- send_nom ");
		
		EmployeeDao edao = new EmployeeDao();
		Employee employee = edao.updateEmployeeOne(send_Nom);
		System.out.println("employee : " + employee);
		
		request.setAttribute("oneEmployee", employee);		
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeeUpdateForm.jsp").forward(request, response);		
	}
	/**
	 * getEmployeeUpdateForm에서 수정할 값을 입력후 그 수정값들이 post방식으로 넘어 왔다. 
	 * Form의 name에 해당되는 값들을 getParameter로 받아서 
	 * 생성자로 객체를 만들고 참조값을 넘겨준다. 
	 * 참조값을 받은 변수가 Employee에 set메서드를 찾아가서 getParameter로 받아온 값을 setting 시킨다. 
	 * 수정하고 싶은 값을 가지고 데이터베이스에 값을 수정하기 위한 메서드에 넘긴다. 
	 * 수정된값을 확인하기 위해 redirect로 화면을 보여준다. 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===ModifyEmployeeController / doPost ===");
		request.setCharacterEncoding("UTF-8");
		String employeeno = request.getParameter("EmployeeNo");
		int EmployeeNo = Integer.parseInt(employeeno);
		String employeeid = request.getParameter("EmployeeId");
		String employeepw = request.getParameter("EmployeePw");
		System.out.println("EmployeeNo : " + EmployeeNo);
		System.out.println("employeeid : " + employeeid);
		System.out.println("employeepw : " + employeepw);
		
		Employee employee = new Employee();
		employee.setEmployeeNom(EmployeeNo);
		employee.setEmployeeId(employeeid);
		employee.setEmployeePw(employeepw);
		
		System.out.println("===============");
		
		EmployeeDao edao = new EmployeeDao();
		
		edao.updateEmployee(employee);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeList.jjdev");		
	}
}
