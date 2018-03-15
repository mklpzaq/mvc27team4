/* [mvc27team4] 방민영 */
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
	
	/* 전체학생을 조회해서 리스트화면에 보여주기 위해 다음의 메소드를 선언한다.
	 * 조회 쿼리를 실행한 값을 ResultSet에 담고, 이것을 다시 Student객체에 담은 후 ArrayList<Student>에 담는다.
	 * ArrayList<Student>의 객체참조변수인 list를 리턴한다.
	 * ->리스트화면에서 이 메소드를 실행하면 전체학생 조회값이 담긴 리턴값이 반환되어 화면에 보여진다.
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
	
	/* 화면에서 입력한 값을 DB에 세팅하기 위해 다음의 메소드를 선언한다.
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
