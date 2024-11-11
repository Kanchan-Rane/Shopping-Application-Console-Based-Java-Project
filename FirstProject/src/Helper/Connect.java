package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Scanner;

public class Connect {
	
	public static Connection con=null;
	public static Scanner sc;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(System.getenv("DBURL"),System.getenv("DBUSER"),System.getenv("DBPASS"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	//to get input everytime
	public static Scanner getInput() {
		
		sc=new Scanner(System.in);
		return sc;
		
	}
	
	
}
