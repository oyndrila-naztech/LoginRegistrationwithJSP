package login.submit.registration;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider implements MyProvider {
	static Connection con = null;
	public static Connection getCon() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connurl);
			System.out.println("connected");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static void main(String[]args)
	{
		getCon();
	}
}
