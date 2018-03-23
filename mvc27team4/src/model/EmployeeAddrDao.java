/* [mvc27team4] 이준희 */ 
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAddrDao {
	
	public int deleteEmployeeAddr(String[] employeeAddrNoArr) {
		System.out.println("deleteEmployeeAddr() EmployeeAddrDao.java");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		System.out.println("EmployeeAddrDao.deleteEmployeeAddr()");
		System.out.println("employeeAddrNoArr : " + employeeAddrNoArr);
		
		try {
			connection = DriverDB.driverConnection();
			int employeeAddrNo = 0;
			for(String employeeAddrNoTemp : employeeAddrNoArr) {
				String sql = "DELETE FROM employee_addr WHERE employee_addr_no = ?";
				preparedStatement = connection.prepareStatement(sql);
				System.out.println("employeeAddrNoTemp : " + employeeAddrNoTemp);
				employeeAddrNo = Integer.parseInt(employeeAddrNoTemp);
				preparedStatement.setInt(1, employeeAddrNo);
				result = preparedStatement.executeUpdate();
			}			
		
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 회원 넘버에 해당하는 회원 주소값을 보여주기위한 메서드이다. 
	 * 	전체리스트에서 한명에 해당하는 int형으로된 넘버값을 받았기 때문에 메서드에 변수는 int로 섰다.
	 * 	한명에 해당되는 값(list)를 리턴한다. 
	 */	
	public ArrayList<EmployeeAddr> selectEmployeeAddr(int employeeNo) {
		EmployeeAddr employeeAddr = null;
		ArrayList<EmployeeAddr> list = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverDB.driverConnection();
			
			String sql = "SELECT * FROM employee_addr WHERE employee_no = ? ORDER BY employee_addr_no ASC";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeNo);
			resultSet = preparedStatement.executeQuery();			
			
			list = new ArrayList<EmployeeAddr>();
			while(resultSet.next()) {
				employeeAddr = new EmployeeAddr();
				
				employeeAddr.setEmployeeAddrNo(resultSet.getInt("employee_addr_no"));
				employeeAddr.setEmployeeNo(resultSet.getInt("employee_no"));
				employeeAddr.setAddress(resultSet.getString("address"));
				list.add(employeeAddr);				
			}			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return list;
	}	
	/*
	 * 테이블안에 입력된 값이 몇개가 되는지 알아보는 메서드이다.
	 * 변수로는 EmployeeAddr의 필드값을 사용한다.
	 * 리턴 result엔 employee_addr 테이블안의 값 갯수가 리턴된다.
	 */
	private int countAddr(EmployeeAddr employeeAddr) {
		System.out.println("countAddr() EmployeeAddr.java ");
		System.out.println(employeeAddr.toString());
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		
		try {
			connection = DriverDB.driverConnection();
			String sql = "SELECT COUNT(employee_addr_no) AS addrCount FROM employee_addr WHERE employee_no = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeAddr.getEmployeeNo());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("addrCount : " + resultSet.getInt("addrCount"));
				result = resultSet.getInt("addrCount");
			}		
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return result;
	}
	/*
	 * AddEmployeeAddrController 에 dopost()메소드에서 설정된(넘버,주소)값이 변수에 들어간다.
	 * EmployeeAddr에 값이 얼마나 들어있는지 수를 새서 5보다 작을시 화면에 출력이 되고 
	 * 5보다 크면 화면에 출력되지 않는다. 
	 */
	public int insertEmployeeAddr(EmployeeAddr employeeAddr) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		int count = this.countAddr(employeeAddr);
		try {
		if(count < 5) {			
			connection = DriverDB.driverConnection();
			String sql = "INSERT INTO employee_addr(employee_no, address) VALUES(?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeAddr.getEmployeeNo());
			preparedStatement.setString(2, employeeAddr.getAddress());
			result = preparedStatement.executeUpdate();
		}else {
			result = 2;			
		 }
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		return result;
	}
}
