import java.sql.*;

public class SQLConnection {
	public Connection makeConnection()	{
		String url = "jdbc:mysql://localhost:3306/bakery?autoReconnect=true&useSSL=false";
		
		String id = "root";
		String password = "1234";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,id,password);
		}	catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�. ");
		}
		
		return con;
	}
}
