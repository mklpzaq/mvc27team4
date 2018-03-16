/* [mvc27team4] 이춘림 */
package model;
import model.DriverDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeacherDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ArrayList<Teacher> list = null;
	Teacher teacher = null;
	int result = 0;
	
	
	
	public int deleteTeacher(int teacherNo) {	
		
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
	 *
	 */
	public int updateTeacher(Teacher teacher) {
		System.out.println("TeacherDao.updateTeacher");
		System.out.println("teacher : " + teacher);
		
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
	 * 
	 */
	public Teacher updateTeacherOne(int teacherNo) {
		System.out.println("teacherNo : "+ teacherNo);
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
	 * 
	 */
	public ArrayList<Teacher> selectTeacher(){
		try {
			connection = DriverDB.driverConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM teacher");
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
	 * 1. 우선 insertTeacher 매서드를 호출하기 전에 addTeacher.jsp 화면에서
	 *  사용자가 새로 가입할 ID와 PW를 입력하게 되는데,  
	 * */
	public int insertTeacher(Teacher teacher) {

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
