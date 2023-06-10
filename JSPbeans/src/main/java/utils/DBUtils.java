package utils;
import java.sql.*;
public class DBUtils {
	private static Connection cn;
//write a method to open db connection
	public static Connection openConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true";
		cn=DriverManager.getConnection(url, "tushar2", "tushar@123");
		return cn;
	}
	//write a method to close db connection
	public static void closeConnection() throws SQLException{
		if(cn != null)
			cn.close();
		System.out.println("db cn closed...");
	}
	
}
