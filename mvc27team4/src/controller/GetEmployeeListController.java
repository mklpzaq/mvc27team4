/* [mvc27team4] 이준희 */
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDao;

/**
 *  addEmployee.jsp에 잇는 폼에서 넘겨왓고 -AddEmployeeController- 클래스에 잇는 doPost메서드에서 넘겨온값을 받아 setting하고 처리한 값을 
 *  받아 여기 -GetEmployeeListController- 로 redirect 했다.
 *  여기서 하고 싶은것은 ? : 우리는 직원정보입력화면에서 입력이 끝나면 직원전체 list를 보여주고 싶다.
 *  				  여기서 회원전체리스트를 화면에 뿌려준다. 
 *  이쪽에서는 다시 리스트만 보여주는 화면으로 이동만 시키면 되기 때문에 forward로 절대경로를 써서 화면을 이동시킨다. 
 *  우리는 데이터베이스에 저장되어 있는 직원정보 전체를 화면에 보여주고 싶기 때문에 데이터에 담겨있는 정보를 가져오는 메서드를 실행하고 
 *  그정보를 받아와서   setAttribute에 이름을 입력하고 list의 값을 저장한다. 
 *  			  
 */
@WebServlet("/getEmployeeList.jjdev")
public class GetEmployeeListController extends HttpServlet {   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao edao = new EmployeeDao();
		request.getParameter("send_Nom");
		ArrayList<Employee> list = edao.selectEmployee();
		request.setAttribute("selectemployee", list);		
		
		request.getRequestDispatcher("/WEB-INF/views/employee/getEmployeelist.jsp").forward(request, response);
		
	}

}
