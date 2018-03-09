package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
	Connection connection = null;
	
	public Connection driverConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf8";
			String id = "root";
			String pw = "java0000";
			
			connection = DriverManager.getConnection(url, id, pw);
		
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("DriverDB.driverConnection() : ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("DriverDB.driverConnection() : SQLException");
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("DriverDB.driverConnection() : connection.close() ¿À·ù");
				}
			}
		}
		return connection;
	}
}
