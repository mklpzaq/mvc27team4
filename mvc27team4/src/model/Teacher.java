/* [mvc27team4] ¿Ã√·∏≤ */
package model;

public class Teacher {
	int teacherNo;
	String teacherId;
	String teacherPw;
	String teacherAddr;
	public int getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherPw() {
		return teacherPw;
	}
	public void setTeacherPw(String teacherPw) {
		this.teacherPw = teacherPw;
	}
	public String getTeacherAddr() {
		return teacherAddr;
	}
	public void setTeacherAddr(String teacherAddr) {
		this.teacherAddr = teacherAddr;
	}
	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", teacherId=" + teacherId + ", teacherPw=" + teacherPw
				+ ", teacherAddr=" + teacherAddr + "]";
	}
	
	
	

	
	
}
