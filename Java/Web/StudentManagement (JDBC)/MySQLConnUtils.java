import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils 
{
	 public static Connection openConnection() throws SQLException 
	 {
	     String hostName = "localhost";
	     String dbName = "student_management";
	     String userName = "root";
	     String password = "";
	     String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	     
	     return DriverManager.getConnection(url, userName, password); 
	 }
	 
	 public static void printConnectionInfo(Connection connect) throws SQLException 
	 {
		 System.out.println(connect.getMetaData().getDatabaseProductName().toString());
		 System.out.println(connect.getMetaData().getDatabaseProductVersion().toString());
	 }
}
