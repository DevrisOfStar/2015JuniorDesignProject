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
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다. ");
		}
		
		return con;
	}
}
