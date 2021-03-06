/* [mvc27team4] 이준희 */ 
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddr;
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
		request.setCharacterEncoding("UTF-8");
		String temp = request.getParameter("employeeNo");
		System.out.println("=========" + temp);
		int employeeNo = Integer.parseInt(temp);
		System.out.println("employeeNo :" + employeeNo);
		request.setAttribute("employeeNo", employeeNo);
		
		request.getRequestDispatcher("WEB-INF/views/employee/addEmployeeAddrForm.jsp").forward(request, response);
	}
	
	/**
	 * 주소입력창(addEmployeeAddrForm.jsp)에서 값을 받아온다.
	 * 직원넘버를 확인 하고 넘버값이 같은 곳에 주소를 추가한다.
	 * insertEmployeeAddr(employeeAddr) 메서드를 불러올때 인수를 employeeAddr(넘버와 주소가 셋팅된)값을 인수로 사용한다.
	 * result(insertEmployeeAddr(): 여기서 리턴된값)이 2 이면 입력갯수 초과 창이 뜨게 한다. 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("==AddEmployeeAddrController / doPost==");
		 request.setCharacterEncoding("UTF-8");
		 String temp = request.getParameter("employeeNo");
		 int employeeNo = Integer.parseInt(temp);		
		 String address = request.getParameter("address");
		 System.out.println("address :" + address);
		 
		 EmployeeAddr employeeAddr = new EmployeeAddr();
		 employeeAddr.setEmployeeNo(employeeNo);
		 employeeAddr.setAddress(address);
		 EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		 int result = employeeAddrDao.insertEmployeeAddr(employeeAddr);
		 System.out.println("result : " + result);
		 
		 if(result == 2) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('address 입력 갯수 5개를 초과하셨습니다.');");
				out.println("location.href='./getEmployeeAddrList.jjdev?employeeNo=" + employeeNo + "';");
				out.println("</script>");
				out.close();
				return ;
			}
			response.sendRedirect(request.getContextPath() + "/getEmployeeAddrList.jjdev?employeeNo=" + employeeNo);
	}

}
