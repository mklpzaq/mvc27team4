/* [mvc27team4] 이춘림 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeacherAddrDao;
import model.TeacherDao;

@WebServlet("/removeTeacher.jjdev")
public class RemoveTeacherController extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveTeacherController / doGet");
		String temp = request.getParameter("teacherNo");
		int teacherNo = Integer.parseInt(temp);
		System.out.println("teacherNo : " + teacherNo);
		
		TeacherAddrDao teacherAddrDao = new TeacherAddrDao();
		int countAddr = teacherAddrDao.countAddr(teacherNo);
		if(countAddr > 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('address를 먼저 모두 삭제해주세요.');");
			out.println("location.href='./getTeacherAddrList.jjdev?teacherNo=" + teacherNo + "';");
			out.println("</script>");
			out.close();
			return ;
		}else {
			TeacherDao teacherDao = new TeacherDao();
			teacherDao.deleteTeacher(teacherNo);
		}
		response.sendRedirect(request.getContextPath() + "/getTeacherList.jjdev");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
