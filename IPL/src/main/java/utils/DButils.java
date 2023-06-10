package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
	
	private static Connection con ;
	static String url= "jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true";
	public static Connection openConnection()throws SQLException
	{
		con = DriverManager.getConnection(url, "tushar2", "tushar@123");
		return con ;
	}
	public static void closeConnection () throws SQLException
	{
		if(con!=null)
			con.close();
		System.out.println("close connection");
	}
}
