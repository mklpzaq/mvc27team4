/* [mvc27team4] 이춘림 */
package model;
import model.DriverDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherDao {
	/*
	 * deleteTeacher() 메서드는,
	 * 키값에 해당되는 teacherNo값을 매개변수로 받아,
	 * SQL DELETE문을 통해 teacherNo값에 해당되는 레코드를 삭제 시킨다.
	 * executeUpdate() 메서드의 결과값을 리턴한다.
	 * */
	public int deleteTeacher(int teacherNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		System.out.println("TeacherDao.deleteTeacher");
		System.out.println("teacherNo : " + teacherNo);
		try {
			connection = DriverDB.driverConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM teacher WHERE teacher_no = ?");
			preparedStatement.setInt(1, teacherNo);
			result = preparedStatement.executeUpdate();
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.deleteTeacher / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.deleteTeacher / SQLException");
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.deleteTeacher / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.deleteTeacher / connection.close() / SQLException");
				}
			}
		}
		return result;
	}
	
	/*
	 * updateTeacher() 메서드는,
	 * modifyTeacherForm.jsp에서 수정한 Teacher 정보를 세팅시킨 Teacher객체의 주소를 매개변수로 받아,
	 * SQL UPDATE문을 통해 없데이트 시키고
	 * executeUpdate() 매서드의 결과값을 리턴한다.
	 */
	public int updateTeacher(Teacher teacher) {
		System.out.println("TeacherDao.updateTeacher");
		System.out.println("teacher : " + teacher);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverConnection();
			preparedStatement = connection.prepareStatement("UPDATE teacher SET teacher_id = ?, teacher_pw = ? WHERE teacher_no = ?");
			preparedStatement.setString(1, teacher.getTeacherId());
			preparedStatement.setString(2, teacher.getTeacherPw());
			preparedStatement.setInt(3, teacher.getTeacherNo());
			result = preparedStatement.executeUpdate();
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.updateTeacher / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.updateTeacher / SQLException");
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.updateTeacher / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.updateTeacher / connection.close() / SQLException");
				}
			}
		}
		return result;
	}
	
	/*
	 * updateTeacherOne() 매서드는
	 * 키값이 되는 teacherNo값을 매개변수로 받아,
	 * teacherNo에 해당되는 레코드(teacher_no, teacher_id, teacher_pw 속성명이 포함된 레코드)를 SELECT하고
	 * 속성값을 얻어, 새로 생성한 Teacher객체의 맴버변수(teacherNo, teacherId, teacherPw)에 각각 세팅시켜 준다.
	 * 그리고 세팅한  Teacher객체의 주소를 리턴(반환)시켜 준다.
	 */
	public Teacher updateTeacherOne(int teacherNo) {
		System.out.println("teacherNo : "+ teacherNo);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Teacher teacher = null;
		try {
			connection = DriverDB.driverConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE teacher_no = ?");
			preparedStatement.setInt(1, teacherNo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				teacher = new Teacher();
				teacher.setTeacherNo(resultSet.getInt("teacher_no"));
				teacher.setTeacherId(resultSet.getString("teacher_id"));
				teacher.setTeacherPw(resultSet.getString("teacher_pw"));
				System.out.println("teacher : " + teacher);
			}
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.updateTeacherOne / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.updateTeacherOne / SQLException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.updateTeacherOne / resultSet.close() / SQLException");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.updateTeacherOne / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.updateTeacherOne / connection.close() / SQLException");
				}
			}
		}
		return teacher;
	}
	
	
	
	
	/*
	 * teacherRowCount() 매서드는 teacher테이블의 모든 행의 개수를 구하는 매서드이다.
	 * 구하여진 모든 행의 개수가 리턴된다.
	 * */
	public int teacherRowCount() {
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		/*
		 * SELECT count(*) FROM teacher
		 * 전체행의 개수 구함
		 * */
		try {
			connection = DriverDB.driverConnection();
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS rowCount FROM teacher");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt("rowCount");
			}
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.selectTeacher() / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.selectTeacher() / SQLException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.selectTeacher() / resultSet.close() / SQLException");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.selectTeacher() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.selectTeacher() / connection.close() / SQLException");
				}
			}
		}
		
		
		
		return count;
	}
	
	
	
	
	/*
	 * selectTeacher() 매서드는 DB에 접근하여,
	 * teacher테이블의 모든 속성(teacher_no, teacher_id, teacher_pw)에 해당되는
	 * 값을 얻어 Teacher객체의 맴버변수(teacherNo, teacherId, teacherPw)에 각각 세팅하고
	 * 세팅된 Teacher객체들을 ArrayList<Teacher> list에 담아 리턴시키는 메서드이다.
	 */
	public ArrayList<Teacher> selectTeacher(int startRow, int pagePerRow){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Teacher> list = null;
		Teacher teacher = null;
		try {
			connection = DriverDB.driverConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM teacher LIMIT ?, ?");
			//==================
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, pagePerRow);
			//===================
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<Teacher>();
			while(resultSet.next()) {
				teacher = new Teacher();
				teacher.setTeacherNo(resultSet.getInt("teacher_no"));
				teacher.setTeacherId(resultSet.getString("teacher_id"));
				teacher.setTeacherPw(resultSet.getString("teacher_pw"));
				list.add(teacher);
			}
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.selectTeacher() / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherDao.selectTeacher() / SQLException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.selectTeacher() / resultSet.close() / SQLException");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.selectTeacher() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherDao.selectTeacher() / connection.close() / SQLException");
				}
			}
		}
		return list;
	}
	
	/*
	 * insertTeacher 매서드 설명
	 * 입력받은 ID, PW 값을 미리 세팅한 Teacher객체를 매개변수로 받아,
	 * SQL INSERT문을 통해 DB에 Insert시키고 
	 * executeUpdate() 매서드의 결과값을 리턴한다.
	 * */
	public int insertTeacher(Teacher teacher) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = DriverDB.driverConnection();
			String sql = "INSERT INTO teacher(teacher_id, teacher_pw) VALUES(?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getTeacherId());
			preparedStatement.setString(2, teacher.getTeacherPw());
			result = preparedStatement.executeUpdate();
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
		return result;
	}
}
