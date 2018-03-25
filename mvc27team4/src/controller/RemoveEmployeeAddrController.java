package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeAddrDao;

@WebServlet("/removeEmployeeAddr.jjdev")
public class RemoveEmployeeAddrController extends HttpServlet {
	  /**
	   * getEmployeeAddrList 에서 체크박스에 체크된 값을 받아옵니다.
	   * 체크박스에서 넘어오는 값은 배열형으로 넘어 오기때문에 배열값에 대입시켜준다.
	   * 
	   */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet RemoveEmployeeAddrController.java");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost RemoveEmployeeAddrController.java");
		
		String employeeNo = request.getParameter("employeeNo");
		String[] employeeAddrNoArr = request.getParameterValues("deleteAddrCheck");
		System.out.println("employeeNo : " + employeeNo);
		if(employeeAddrNoArr != null) {
			for(String str : employeeAddrNoArr) {
				System.out.println(str + "<---employeeAddrNoArr.str");
			}
		}else {
			System.out.println("employeeAddrNoArr : " + employeeAddrNoArr);
		}
		
		EmployeeAddrDao employeeAddrDao = new EmployeeAddrDao();
		employeeAddrDao.deleteEmployeeAddr(employeeAddrNoArr);
		
		response.sendRedirect(request.getContextPath() + "/getEmployeeAddrList.jjdev?employeeNo=" + employeeNo);
	}

}
