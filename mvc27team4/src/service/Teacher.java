// [mvc27team4] ¿Ã√·∏≤
package service;

public class Teacher {
	int teacherNo;
	String teacherId;
	String teacherPw;
	
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
	
	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", teacherId=" + teacherId + ", teacherPw=" + teacherPw + "]";
	}
	
	
}
