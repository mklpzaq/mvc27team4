/* [mvc27team4] 이춘림 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddrDao;

@WebServlet("/removeTeacherAddr.jjdev")
public class RemoveTeacherAddrController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet RemoveTeacherAddrController.java");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost RemoveTeacherAddrController.java");
		//체크된 라인의 teacher_addr_no 값이 들어왔다고 가정한다.
		//getTeacherAddrList.jsp로 가기 위해서는 teacher_no값이 있어야 한다. 따라서 RemoveTeacherAddrController로 넘어오기 전 페이지에서 teacher_no값을 넘겨주어야 한다.
		String teacherNo = request.getParameter("teacherNo");
		String[] teacherAddrNoArr = request.getParameterValues("deleteAddrCheck");
		System.out.println("teacherNo : " + teacherNo);
		if(teacherAddrNoArr != null) {
			for(String str : teacherAddrNoArr) {
				System.out.println(str + "<-- teacherAddrNoArr.str");
			}
		}else {
			System.out.println("teacherAddrNoArr : " + teacherAddrNoArr);
		}
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		teacherAddrDao.deleteTeacherAddr(teacherAddrNoArr);
		
		response.sendRedirect(request.getContextPath() + "/getTeacherAddrList.jjdev?teacherNo=" + teacherNo);
	}

}
