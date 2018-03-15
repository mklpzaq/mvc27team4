/* [mvc27team4] ��ο� */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	
	Connection connection = null;
	PreparedStatement statement = null;
	Student student = null;
	String sql = null;
	ArrayList<Student> list = null;
	ResultSet resultSet = null;
	int result = 0;
	
	public int deleteStudent(int studentNo) {
		try {
			connection = DriverDB.driverConnection();
			sql = "DELETE FROM student WHERE student_no=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int updateStudent(Student student) {
		try {
			connection = DriverDB.driverConnection();
			sql = "UPDATE student SET student_id=?,student_pw=? WHERE student_no=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getStudentPw());
			statement.setInt(3, student.getStudentNo());
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/* ��ü�л��� ��ȸ�ؼ� ����Ʈȭ�鿡 �����ֱ� ���� ������ �޼ҵ带 �����Ѵ�.
	 * ��ȸ ������ ������ ���� ResultSet�� ���, �̰��� �ٽ� Student��ü�� ���� �� ArrayList<Student>�� ��´�.
	 * ArrayList<Student>�� ��ü���������� list�� �����Ѵ�.
	 * ->����Ʈȭ�鿡�� �� �޼ҵ带 �����ϸ� ��ü�л� ��ȸ���� ��� ���ϰ��� ��ȯ�Ǿ� ȭ�鿡 ��������.
	 */
	public ArrayList<Student> selectStudent(){
		list = new ArrayList<Student>();
		try {
			connection = DriverDB.driverConnection();
			sql = "SELECT * FROM student";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				student.setStudentId(resultSet.getString("student_id"));
				student.setStudentPw(resultSet.getString("student_pw"));
				list.add(student);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/* ȭ�鿡�� �Է��� ���� DB�� �����ϱ� ���� ������ �޼ҵ带 �����Ѵ�.
	 */
	public int insertStudent(Student student) {
		try {
			connection = DriverDB.driverConnection();
			sql = "INSERT INTO student(student_id, student_pw) VALUES(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getStudentPw());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
