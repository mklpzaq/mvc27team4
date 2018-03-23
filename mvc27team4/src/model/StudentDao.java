/*[mvc27team4] 방민영*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	/*아래의 것들은 공유하지 않는다.
	Connection connection = null;
	PreparedStatement statement = null;
	Student student = null;
	ArrayList<Student> list = null;
	ResultSet resultSet = null;
	int result = 0;*/
	
	public int deleteStudent(int studentNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			connection = DriverDB.driverConnection();
			String sql = "DELETE FROM student WHERE student_no=?";
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
	
	/* 수정버튼을 눌렀을 때 
	 * 
	 */
	public Student updateStudentOne(int studentNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		Student student = null;
		ResultSet resultSet = null;
		try {
			connection = DriverDB.driverConnection();
			String sql = "SELECT * FROM student WHERE student_no=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				student = new Student();
				student.setStudentNo(resultSet.getInt("student_no"));
				student.setStudentId(resultSet.getString("student_id"));
				student.setStudentPw(resultSet.getString("student_pw"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return student;
	}
	
	/* 수정버튼을 눌러 값을 변경한 후 변경된 값을 업데이트하기 위한 메소드이다.
	 * 쿼리실행값을 result에 담아 리턴한다.
	 */
	public int updateStudent(Student student) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			connection = DriverDB.driverConnection();
			String sql = "UPDATE student SET student_id=?,student_pw=? WHERE student_no=?";
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
	
	/*
	 * 
	 */
	public int studentRowCount() {
		int count=0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverDB.driverConnection();
			
			String sql = "SELECT count(*) AS count FROM student";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt("count");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
	/*
	 * student 조회하기 위한 메소드.
	 * 매개변수 int startRow: select결과물의 시작행
	 * 매개변수 int pagePerRow: select결과물의 개수
	 * return: student list
	 */
	public ArrayList<Student> selectStudent(int startRow, int pagePerRow){
		Connection connection = null;
		PreparedStatement statement = null;
		Student student = null;
		ResultSet resultSet = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			connection = DriverDB.driverConnection();
			String sql = "SELECT * FROM student LIMIT ?, ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, startRow);
			statement.setInt(2, pagePerRow);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				student = new Student();
				student.setStudentNo(resultSet.getInt("student_no"));
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
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			connection = DriverDB.driverConnection();
			String sql = "INSERT INTO student(student_id, student_pw) VALUES(?, ?)";
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
