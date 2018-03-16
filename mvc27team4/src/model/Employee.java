/* [mvc27team4] 이준희 */ 
package model;

public class Employee {
	private int employeeNom;
	private String employeeId;
	private String employeePw;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeePw() {
		return employeePw;
	}
	public void setEmployeePw(String employeePw) {
		this.employeePw = employeePw;
	}
	public int getEmployeeNom() {
		return employeeNom;
	}
	public void setEmployeeNom(int employeeNom) {
		this.employeeNom = employeeNom;
	}
	@Override
	public String toString() {
		return "Employee [employeeNom=" + employeeNom + ", employeeId=" + employeeId + ", employeePw=" + employeePw
				+ "]";
	}
	
	
}
