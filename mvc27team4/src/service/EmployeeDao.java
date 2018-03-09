package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class EmployeeDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Employee emplo = null;
	
	public void insertEmployee(Employee employee) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "insert into employee (employee_id, employee_pw) values(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEmployeeId());
			pstmt.setString(2, employee.getEmployeePw());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (SQLException e) {			
				e.printStackTrace();
		}
	}
}
