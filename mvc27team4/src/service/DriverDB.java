// [mvc27team4] ���Ḳ
package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
	Connection connection = null;
	
	public Connection driverConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pw = "java0000";
		
		connection = DriverManager.getConnection(url, id, pw);
		
		return connection;
	}
}
