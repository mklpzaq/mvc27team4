// [mvc27team4] ¹æ¹Î¿µ
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import service.Student;

public class StudentDao {
	
	Connection connection = null;
	PreparedStatement statement = null;
	Student student = null;
	String sql = null;
	
	public void insertStudent(Student student) {
		
		DriverDB driverdb = new DriverDB();
		try {
			connection = driverdb.driverConnection();
			sql = "INSERT INTO student(student_id, student_pw) VALUES(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getStudentPw());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
