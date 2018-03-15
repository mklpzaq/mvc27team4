/* [mvc27team4] ���Ḳ */
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
	
	public int deleteTeacher(int GuestNo) {	//Teahcer teahcer�޾Ƶ� ��
		
		return 0;
	}
	
	public int updateTeacher(Teacher teacher) {
		
		return 0;
	}
	
	
	
	/*
	 * selectTeacher() �ż���� DB���� teacher ���̺� ����� ��� ���ڵ带 ArrayList<Teacher>�� ���
	 * ArrayList<Teacher>�� �ּҸ� ��ȯ�ϴ� �ż����̴�.
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
	 * insertTeacher(Teacher teacher) �ż���� 
	 * Teacher��ü�� �ɹ����� teacherId, teacherPw�� ������ ���õ� ������ Teacher ��ü�� �ּҰ��� �Ű������� �޴´�.
	 * �׸��� �ż��� ���Ǻκп��� �Ű������� ���� Teacher��ü�� teacherId, teacherPw�� DB�� INSERT��Ų��.
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
