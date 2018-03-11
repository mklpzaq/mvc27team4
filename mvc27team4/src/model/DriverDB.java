/* [mvc27team4] 이춘림 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
	/* 
	 * forName() 메서드를 통해 jdbc드라이버를 로딩하고
	 * DB url정보(IP, 포트번호, DB명)와 DB의 ID, PW 정보를 getConnection()메서드의 매개변수로 넣어 
	 * DB와 연결한 후, getConnection() 메서드의 실행 결과로 생성된 Connection객체의 주소값을 리턴한다. 
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
