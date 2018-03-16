/*[mvc27team4] 방민영*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	
	public ArrayList<StudentAddr> selectStudentAddr(int studentNo) {
		StudentAddr studentAddr = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<StudentAddr> list = new ArrayList<StudentAddr>();
		try {
			connection = DriverDB.driverConnection();
			String sql = "SELECT * FROM student_addr WHERE student_no=? ORDER BY student_addr_no ASC;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentNo);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				studentAddr = new StudentAddr();
				studentAddr.setStudentAddrNo(resultSet.getInt("student_addr_no"));
				studentAddr.setStudentNo(resultSet.getInt("student_no"));
				studentAddr.setAddress(resultSet.getString("address"));
				list.add(studentAddr);
			}
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
		return list;
	}
	
	public int insertStudentAddr(StudentAddr studentAddr) {
		int result=0;

		return result;
	}
}
