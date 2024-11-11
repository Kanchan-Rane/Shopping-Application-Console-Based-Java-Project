package DaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Dao.All;
import Helper.Connect;
import Pojo.Cart;
import Pojo.Products;
import Pojo.User;
import Test.UserTest;

public class DaoImpl1 implements All {
	Connection con=Connect.getConnection();
	Scanner sc=Connect.getInput();
	PreparedStatement ps;
	

	@Override
	public boolean createAdmin(String name) {
		if(name.contains("Admin")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean loginAdmin(String cname ) {
		String name=cname; 
		try{
			String que10="select Cname from User where Cname LIKE '%Admin' ";
			ps=con.prepareStatement(que10);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String na= rs.getString("Cname");
				int y=name.compareTo(na);
				if(y==0) {
					
					return true;
				}
			}
			return false;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	

	@Override
	public boolean createAccount(User u) {
		try {
			String que1="insert into User(Cname,Cnumber,Cemail,Cpassword)values(?,?,?,?)";
			ps=con.prepareStatement(que1);
			ps.setString(1,u.getCustomerName());
			ps.setString(2,u.getPnumber());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getPassword());
			int x=ps.executeUpdate();
			
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	
	@Override
	public int userLogin(String pnumber, String password) {
		try {
			String que2="select Cpassword,Cnumber,CustomerID  from User where Cnumber=?";
			ps=con.prepareStatement(que2);
			ps.setString(1,pnumber);
			ResultSet rs1=ps.executeQuery();
			while(rs1.next()) {
			String pass=rs1.getString("Cpassword");
			int id=rs1.getInt("CustomerID");
			int x=pass.compareTo(password);
			if(x==0) {
				
				return id;
			}
			else {
				
				System.out.println("Enter Right Password");
				return -1;
			}
			}
			System.out.println("Enter registered phone number");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	

}
