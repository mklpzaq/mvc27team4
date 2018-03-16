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
