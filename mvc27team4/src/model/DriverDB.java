/* [mvc27team4] 이춘림 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
	/* 
	 * driverConnection() 메서드는,
	 * DB연결에 필수요소인 Driver.class를 forName()메서드를 통해 로딩시키고 
	 * DB연결에 필요한 5가지요소(IP, 포트번호, DB명, id, pw)를 담고 있는 url, id, pw 정보값을
	 * DriverManager클래스의 static메서드인 getConnection()메서드의 매개변수로 값을 넘겨주어,
	 * DB와 연결된 Connection객체의 주소를 리턴받는다.
	 * getConnection() 매서드의 실행결과로 리턴받은 Connection객체의 주소를 
	 * 선언한 Connection 객체참조변수 connection에 받은 후,
	 * connection 주소값을 리턴시킨다.
	 * DB연결을 하는 메서드는 사용이 빈번하므로 사용의 편의성을 위해 static메서드로 만들었다.
	 * */
	public static Connection driverConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pw = "java0000";
		Connection connection = DriverManager.getConnection(url, id, pw);
		return connection;
	}
}
