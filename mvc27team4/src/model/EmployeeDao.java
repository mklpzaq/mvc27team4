package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DriverDB;
import java.util.ArrayList;


public class EmployeeDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Employee employee = null;
	ResultSet result = null;
	
	public ArrayList<Employee> SelectEmployee(){
		ArrayList<Employee> list = new  ArrayList<Employee>();	
		try {
			conn = DriverDB.driverConnection();
			String sql = "SELECT employee_no as employeeNom, employee_id as employeeId, employee_pw as employeePw from employee";
			pstmt = conn.prepareStatement(sql); 
			result = pstmt.executeQuery();
			
				while (result.next()) {
				Employee employee = new Employee();
				String employeeNom = result.getString("employeeNom");
				String employeeId = result.getString("employeeId");
				String employeePw = result.getString("employeePw");
				
				employee.setEmployeeNom(employeeNom);
				employee.setEmployeeId(employeeId);
				employee.setEmployeePw(employeePw);
				list.add(employee);
				}		
		
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {			
			if (result != null) try {result.close();} catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null) try {conn.close();} catch (SQLException ex) {}
		}		
		return list;
	}
		
	public void insertEmployee(Employee employee) {				
		try {			
			conn = DriverDB.driverConnection();					
			String sql = "INSERT INTO employee (employee_id, employee_pw) values(?, ?)";			
			
			
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, employee.getEmployeeId());
				pstmt.setString(2, employee.getEmployeePw());
				pstmt.executeUpdate();
				
				pstmt.close();
				conn.close();
			
			} catch (SQLException e) {				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
	
	}
	
}