/* [mvc27team4] 이춘림 */
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherAddrDao {
	/* 
	 * 주소록에서 체크박스로 체크된 주소의 teacher_addr_no 값을 받아와
	 * String형 배열 teacherAddrNoArr에 저장시키고 
	 * deleteTeacherAddr()의 매개변수로 넘겨준다.
	 * deleteTeacherAddr() 매서드가 하는 일은 매개변수로 넘겨받은  String형 배열에 저장된 teacher_addr_no값을 읽어
	 * SQL DELETE문을 통해 teacher_addr_no에 해당하는 레코드를 삭제하는 일이다.
	 * for-each문을 통해 배열은 순회하면서 teacher_addr_no값을 DELETE문 ?(물음표)에 순차적으로 대입하면서,
	 * DELETE를 하는 작업을 수행한다.
	 * 리턴 되는 result값은 executeUpdate()가 성공했는지의 여부를 나타낸다. 성공하면 1, 실패하면 0을 리턴한다.
	 *  */
	public int deleteTeacherAddr(String[] teacherAddrNoArr) {
		System.out.println("deleteTeacherAddr() TeacherAddrDao.java");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		System.out.println("TeacherAddrDao.deleteTeacherAddr()");
		System.out.println("teacherAddrNoArr : " + teacherAddrNoArr);
		try {
			connection = DriverDB.driverConnection();
			int teacherAddrNo = 0;
			if(teacherAddrNoArr != null) {
				for(String teacherAddrNoTemp : teacherAddrNoArr) {
					preparedStatement = connection.prepareStatement("DELETE FROM teacher_addr WHERE teacher_addr_no = ?");
					System.out.println("teacherAddrNoTemp : " + teacherAddrNoTemp);
					teacherAddrNo = Integer.parseInt(teacherAddrNoTemp);
					preparedStatement.setInt(1, teacherAddrNo);
					result = preparedStatement.executeUpdate();
				}
			}
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.deleteTeacherAddr()/ ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.deleteTeacherAddr() / SQLException");
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.deleteTeacherAddr() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.deleteTeacherAddr() / connection.close() / SQLException");
				}
			}
		}
		return result;
	} 
	/*
	 * selectTeacherAddr() 매서드는,
	 * Teacher객체의 teacherNo를 매개변수로 받아서 
	 * teacher_addr 테이블에 접근하여
	 * 속성명 teacher_addr_no, teacher_no, address 값을 얻어
	 * teacherAddr 객체의 맴버변수에 각각 값을 세팅한 다음
	 * ArrayList<TeacherAddr>에 teacherAddr 객체를 넣어주고 리턴시키는 역할을 한다.
	 * */
	public ArrayList<TeacherAddr> selectTeacherAddr(int teacherNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
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
	/* teacher_addr 테이블의 teacher_addr_no 속성의 칼럼갯수를 구하는 매서드
	 * 칼럼갯수를 리턴한다.
	 * insertTeacherAddr() 메서드에서 사용한다.
	 *  */
	private int countAddr(TeacherAddr teacherAddr) {
		System.out.println("countAddr() TeacherAddrDao.java ");
		System.out.println(teacherAddr.toString());
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = DriverDB.driverConnection();
			preparedStatement = connection.prepareStatement("SELECT COUNT(teacher_addr_no) AS addrCount FROM teacher_addr WHERE teacher_no = ?");
			preparedStatement.setInt(1, teacherAddr.getTeacherNo());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("addrCount : " + resultSet.getInt("addrCount"));
				result = resultSet.getInt("addrCount");
			}
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.countAddr / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.countAddr / SQLException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.countAddr / resultSet.close() / SQLException");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.countAddr / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.countAddr / connection.close() / SQLException");
				}
			}
		}
		return result;
	}
	/*
	 * insertTeacherAddr() 메서드는 address를 추가해주는 메서드이다.
	 * address가 어떤 객체의 address인지를 식별하기 위해서는 teacher_addr테이블의 FK키인 teacher_no값이 필요하다.
	 * 또한, address를 추가하기 위해서는 사용자가 입력한 address정보가 필요하다.
	 * 그래서 teacher_no, address 정보를 담고 있는 TeacherAddr객체를 매개변수로 받아 INSERT문을 실행한다.
	 * 
	 * insertTeacherAddr()매서드 실행 초반에 등장하는 countAddr() 메서드는
	 * DB안에 있는 teacher_no값에 대한 address가 몇개인지 구하여 리턴시켜주는 메서드이다.
	 * 
	 * insertTeacherAddr()메서드에서 countAddr()메서드의 결과값이 5미만일 경우에만 INSERT구문이 실행되게 하였고,
	 * executeUpdate() 메서드의 결과값 숫자1, 0(성공, 실패)을 int형 변수 result에 담아 리턴하도록 하였다. 
	 * 
	 * countAddr()메서드의 결과값이 5이상일 경우에는 INSERT구문이 실행되지 않고,
	 * int형 변수 result에 숫자 2를 초기화시켜 리턴시키도록 하였다.
	 * 
	 * insertTeacherAddr() 메서드는 AddTeacherAddrController.java 에서 호출되게 하였는데,
	 * AddTeacherAddrController.java 에서 insertTeacherAddr() 메서드의 리턴값을 이용하여
	 * 5개 초과했을시 적절한 경고창이 나오도록 하였다.
	 * */
	public int insertTeacherAddr(TeacherAddr teacherAddr) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		/* DB안에 있는 address가 몇개인지 구하는 매서드 : countAddr(), address 개수를 리턴한다.*/
		int count = this.countAddr(teacherAddr);
		try {
			/* count가 5미만일 경우만 INSERT 구문을 실행한다. */
			if(count < 5) {
				connection = DriverDB.driverConnection();
				preparedStatement = connection.prepareStatement("INSERT INTO teacher_addr(teacher_no, address) VALUES(?, ?)");
				preparedStatement.setInt(1, teacherAddr.getTeacherNo());
				preparedStatement.setString(2, teacherAddr.getAddress());
				result = preparedStatement.executeUpdate();
			}else {
				/* executeUpdate() 매서드는 SQL문 성공시 1, 실패시 0을 리턴한다. 
				 * else문에 들어왔다는 것은 count가 5를 초과했다는 말이 되는데 
				 * 이때, result값을 2로 초기화하고, result값이 2일 경우에는 
				 * count가 5를 초과한 경우가 된다.
				 *  */
				result = 2;
			}
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.insertTeacherAddr / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("TeacherAddrDao.insertTeacherAddr / SQLException");
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.insertTeacherAddr / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("TeacherAddrDao.insertTeacherAddr / connection.close() / SQLException");
				}
			}
		}
		return result;
	}
}
