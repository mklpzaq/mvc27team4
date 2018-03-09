// [mvc27team4] ¿Ã√·∏≤
package model;
import model.DriverDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	public void insertTeacher(Teacher teacher) {
		DriverDB driverDb = new DriverDB();
		
		try {
			connection = driverDb.driverConnection();
			String sql = "INSERT INTO teacher(teacher_id, teacher_pw) VALUES(?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getTeacherId());
			preparedStatement.setString(2, teacher.getTeacherPw());
			
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.insertTeacher() / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.insertTeacher() / SQLException");
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.insertTeacher() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.insertTeacher() / connection.close() / SQLException");
				}
			}
		}
	}
}
