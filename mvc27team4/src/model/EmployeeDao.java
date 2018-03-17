/* [mvc27team4] 이준희 */ 
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DriverDB;
import java.util.ArrayList;
import model.Employee;

public class EmployeeDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Employee employee = null;
	ResultSet result = null;
	int intReturn = 0;
	
	/**
	 * 수정화면에서 수정하고 싶은 값을 입력후 넘긴값을 데이터베이스에 저장하고 수정하는 쿼리를 작성한다.
	 * 수정된 값을 다시 대입연산자를 사용하여  intReturn에 값을 대입하고 수정된값 intReturn를 리턴시킨다. 
	 */
	public int updateEmployee(Employee employee) {
		try {
			conn = DriverDB.driverConnection();
			String sql ="UPDATE employee SET employee_id=?,employee_pw=? WHERE employee_no = ?";
			pstmt = conn.prepareStatement(sql);			
			
			pstmt.setString(1, employee.getEmployeeId());
			pstmt.setString(2, employee.getEmployeePw());
			pstmt.setInt(3, employee.getEmployeeNom());
			
			intReturn = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return intReturn;
	}	
	
	/**
	 * 직원 넘버값을 기준으로 넘버값에 해당하는 넘버, 아이디, 비밀번호를 가져올것이다. 
	 * 한명의 직원값을 리턴시킨다.
	 */	
	public Employee updateEmployeeOne(int employeeNom) {
		try {
			conn = DriverDB.driverConnection();
			String sql = "select * from employee WHERE employee_no=?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, employeeNom);
			result =pstmt.executeQuery();
			
			if(result.next()) {
				employee = new Employee();
				employee.setEmployeeNom(result.getInt("employee_no"));				
				employee.setEmployeeId(result.getString("employee_id"));
				employee.setEmployeePw(result.getString("employee_pw"));
			}			
			pstmt.close();
			conn.close();		
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return employee;
	}
	
	/**
	 * 데이터베이스에 있는 회원 전체 리스트를 담아서  전체 list를 담아서 보여준다.
	 * 당연히 회원전체 정보를 담은 list를 리턴 시킨다. 
	 */
	public ArrayList<Employee> selectEmployee(){
		ArrayList<Employee> list = new  ArrayList<Employee>();	
		try {
			conn = DriverDB.driverConnection();
			String sql = "SELECT employee_no as employeeNom, employee_id as employeeId, employee_pw as employeePw from employee";
			pstmt = conn.prepareStatement(sql); 
			result = pstmt.executeQuery();
			
				while (result.next()) {
					Employee employee = new Employee();
					int employeeNom = result.getInt("employeeNom");
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
	/**
	 * 	직원입력처리 메서드이다. 변수값은 Employee클래스의 참조변수로 사용한다.  	
	 * 	addEmployee.jsp에 있는 폼에서 넘겨온 값이 셋팅되어 spl로 데이터값이 저장된다. 
	 */
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