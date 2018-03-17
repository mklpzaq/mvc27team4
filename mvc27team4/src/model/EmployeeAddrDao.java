/* [mvc27team4] 이준희 */ 
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAddrDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	
	/**
	 * 회원 넘버에 해당하는 회원 주소값을 보여주기위한 메서드이다. 
	 * 	전체리스트에서 한명에 해당하는 int형으로된 넘버값을 받았기 때문에 메서드에 변수는 int로 섰다.
	 * 	한명에 해당되는 값(list)를 리턴한다. 
	 */
	public ArrayList<EmployeeAddr> selectEmployeeAddr(int employeeNo) {
		EmployeeAddr employeeAddr = null;
		ArrayList<EmployeeAddr> list = null;
		
		try {
			conn = DriverDB.driverConnection();
			
			String sql = "SELECT * FROM employee_addr WHERE employee_no = ? ORDER BY employee_addr_no ASC";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeNo);
			result = pstmt.executeQuery();			
			
			list = new ArrayList<EmployeeAddr>();
			while(result.next()) {
				employeeAddr = new EmployeeAddr();
				
				employeeAddr.setEmployeeAddrNo(result.getInt("employee_addr_no"));
				employeeAddr.setEmployeeNo(result.getInt("employee_no"));
				employeeAddr.setAddress(result.getString("address"));
				list.add(employeeAddr);				
			}			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		
		return list;
	}	
	
	public int insertEmployeeAddr(EmployeeAddr employeeAddr) {
		
		
		
		return 0;
	}
}
