package DaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import Dao.Menu;
import Helper.Connect;
import Helper.ExitFromAcc;
import Pojo.Cart;
import Pojo.Products;
import Test.UserTest;

public class DaoImpl2 implements Menu {
	static Connection con=Connect.getConnection();
	static Scanner sc=Connect.getInput();
	static PreparedStatement ps;
	static ArrayList<Cart> al=new ArrayList<Cart>();
	
	
	
	public static void  navigation(int cid) {
	ExitFromAcc e= new ExitFromAcc();
//		sc=new Scanner(System.in);
		int cg=2;
		DaoImpl2 D=new DaoImpl2();
		
		System.out.println("\n1.Add to cart\n2.Back\n3.Go to the Home page\n4.Exit");
		int ch=sc.nextInt();
		if(ch==1) {
			System.out.println("Please enter Product id: ");
			int cc=sc.nextInt();
			System.out.println("Please enter units you want to purchase: ");
			int u=sc.nextInt();
		    addtocart(cid,cc,u);
		    }
		else if(ch==2) {
		   D.products(cid);
		   }
		else if(ch==4){
			e.exit();
			}
		else {
			UserTest u=new UserTest();
			u.homepage(cid,cg);
			}
	}
	
	
	
	public static boolean cart(int c,int p,String n,int un,double dd,String s) {
//		PreparedStatement ps;
		con=Connect.getConnection();
		try{
			
			String que1="insert into Cart(CustomerID,ProductID,Pname,Punits,Pprice,Pcategory)values(?,?,?,?,?,?)";
			ps=con.prepareStatement(que1);
			ps.setInt(1,c);
			ps.setInt(2,p);
			ps.setString(3,n);
			ps.setInt(4, un);
			ps.setDouble(5,dd);
			ps.setString(6,s);
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

	public boolean products(int cid) {
		
		DaoImpl2 dr=new DaoImpl2();
		
		try {
			System.out.println("1.Clothes\n2.BeautyProducts\n3.Electronics");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				String qe1="MensClothes",qe2="WomensClothes";
				String que3="select * from Product where Pcategory=? or Pcategory=?";
				ps=con.prepareStatement(que3);
				ps.setString(1, qe1);
				ps.setString(2, qe2);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int id=rs.getInt("ProductID");
					String name=rs.getString("Pname");
					int unit=rs.getInt("Punits");
					double price=rs.getDouble("Pprice");
					String category=rs.getString("Pcategory");
					Products pp=new Products(id,name,unit,price,category);
					System.out.println(pp.toString());
					}
				dr.navigation(cid);
				break;
			case 2:
				String qe3="BeautyProducts";
				String que4="select * from Product where Pcategory=?";
				ps=con.prepareStatement(que4);
				ps.setString(1, qe3);
				ResultSet rs1=ps.executeQuery();
				while(rs1.next()) {
					int id=rs1.getInt("ProductID");
					String name=rs1.getString("Pname");
					int unit=rs1.getInt("Punits");
					double price=rs1.getDouble("Pprice");
					String category=rs1.getString("Pcategory");
					Products pp=new Products(id,name,unit,price,category);
					System.out.println(pp.toString());
					}
				
				dr.navigation(cid);
				break;
			case 3:
				String qe4="Electronics";
				String que5="select * from Product where Pcategory=?";
				ps=con.prepareStatement(que5);
				ps.setString(1, qe4);
				ResultSet rs2=ps.executeQuery();
				while(rs2.next()) {
					int id=rs2.getInt("ProductID");
					String name=rs2.getString("Pname");
					int unit=rs2.getInt("Punits");
					double price=rs2.getDouble("Pprice");
					String category=rs2.getString("Pcategory");
					Products pp=new Products(id,name,unit,price,category);
					System.out.println(pp.toString());
					}
				
				dr.navigation(cid);
				break;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public static Cart addtocart(int cid,int pid,int u) {
		Cart c=new Cart(cid,00,"No product yet",0,00.00,"Not any yet");
		try {
			
			String que="select * from Product where ProductID=?";
		    ps=Connect.con.prepareStatement(que);
		    ps.setInt(1, pid);
		    ResultSet rs2=ps.executeQuery();
		    while(rs2.next()) {
				String name=rs2.getString("Pname");
				int unit=rs2.getInt("Punits");
				double price=rs2.getDouble("Pprice");
				String category=rs2.getString("Pcategory");
				if(unit>=u) {
					double prices=u*price;
					boolean b=cart(cid,pid,name,u,prices,category);
					if(b==true) {
		    		System.out.println(name+" successfully added to the cart!! ");
					}else {System.out.println("SOMETHING WENT WRONG!!!");}
		    		navigation(cid);
		    	
		    	}
		    	else {
		    		
		    		System.out.println("SORRY FOR THE INCONVENIENCE\nYour desired product have only few "+
		    				"units left!!! We will try to get the more stock available soon!!");
		    		navigation(cid);
		    		return c;
		    	}
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}

}
