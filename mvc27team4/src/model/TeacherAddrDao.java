/* [mvc27team4] 이춘림 */
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherAddrDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public ArrayList<TeacherAddr> selectTeacherAddr(int teacherNo) {
		TeacherAddr teacherAddr = null;
		ArrayList<TeacherAddr> list = null;
		
		try {
			connection = DriverDB.driverConnection();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM teacher_addr WHERE teacher_no = ? ORDER BY teacher_addr_no ASC");
			preparedStatement.setInt(1, teacherNo);
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<TeacherAddr>();
			while(resultSet.next()) {
				teacherAddr = new TeacherAddr();
				teacherAddr.setTeacherAddrNo(resultSet.getInt("teacher_addr_no"));
				teacherAddr.setTeacherNo(resultSet.getInt("teacher_no"));
				teacherAddr.setAddress(resultSet.getString("address"));
				list.add(teacherAddr);
			}
			
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.insertTeacherAddrOne / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.insertTeacherAddrOne / SQLException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.insertTeacherAddrOne / resultSet.close() / SQLException");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.insertTeacherAddrOne / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.insertTeacherAddrOne / connection.close() / SQLException");
				}
			}
		}

		return list;
	}
	
	public int insertTeacherAddr(TeacherAddr teacherAddr) {
		int result = 0;
		
		
		
		return result;
	}
}
