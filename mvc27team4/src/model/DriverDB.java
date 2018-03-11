/* [mvc27team4] ���Ḳ */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
	/* 
	 * forName() �޼��带 ���� jdbc����̹��� �ε��ϰ�
	 * DB url����(IP, ��Ʈ��ȣ, DB��)�� DB�� ID, PW ������ getConnection()�޼����� �Ű������� �־� 
	 * DB�� ������ ��, getConnection() �޼����� ���� ����� ������ Connection��ü�� �ּҰ��� �����Ѵ�. 
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
