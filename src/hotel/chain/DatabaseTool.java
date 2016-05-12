package hotel.chain;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;


public class DatabaseTool {
	static String dbUrl = "jdbc:mysql://localhost:3306/mydb";
	static String user = "cs9321";
	static String password = "cs9321";
	
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		Properties connectionProp = new Properties();
		conn = DriverManager.getConnection(dbUrl, user, password);
	    return conn;
	}
	
	public static void endConnection(Connection conn) throws SQLException{
		conn.close();		
	}
	
}
