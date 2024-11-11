package DaoImplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import Dao.Menu;
import Helper.Connect;
import Helper.ExitFromAcc;
import Pojo.Cart;
import Pojo.Order;
import Pojo.Products;
import Pojo.User;

public class DaoImpl2b extends DaoImpl2 implements Menu {
	private static final String ye = null;
//	Connection con=Connect.getConnection();
//Scanner sc=Connect.getInput();
//	PreparedStatement ps;
	static ExitFromAcc ef=new ExitFromAcc();
	static DaoImpl2c c2=new DaoImpl2c();

	public static void navigation2(int id,int c) {
		
//		Scanner sc=Connect.getInput();
		DaoImpl2b d= new DaoImpl2b();
//		ExitFromAcc ef=new ExitFromAcc();
		System.out.println("\n\nIf you want to exit press 1 \nIf you want to go back press 2");
		int xz=sc.nextInt();
		if(xz==2 && (c==3 ||c==4)) {d.adminMenu(id,c);}
		else if(xz==2 && (c==1 ||c==2)) {d.userLogin(id, c);}
		else  {ef.exit();}
		
	}
	
	public void adminMenu(int did,int c) {
	
		System.out.println("1.To See All the Customers\n2.To Update Data\n3.To See All the available Products\n4.To exit");
		int e=sc.nextInt();
		if(e==1) {
			try {
				String que23="select * from User";
				ps=con.prepareStatement(que23);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int i=rs.getInt("CustomerID");
					String names=rs.getString("Cname");
					String num=rs.getString("Cnumber");
					String em=rs.getString("Cemail");
					String pass=rs.getString("Cpassword");
					User u=new User(names,pass,em,num);
					System.out.println("User [CustomerID ="+i+u.toString());
				}
				navigation2(did,c);
			}
			catch(Exception en) {
				en.printStackTrace();
			}
		}else if(e==3) {
			try {
			String que23="select * from Product";
			ps=con.prepareStatement(que23);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int i=rs.getInt("ProductID");
				String names=rs.getString("Pname");
				int un=rs.getInt("Punits");
				double pp=rs.getDouble("Pprice");
				String pc=rs.getString("Pcategory");
				Products p=new Products(i,names,un,pp,pc);
				System.out.println(p.toString());
			}
			navigation2(did,c);
		}
		catch(Exception en) {
			en.printStackTrace();
		}
		}
		else if(e==4) {
			ef.exit();
		}
		else if(e==2) {
			System.out.println("1.To add new product\n2.To delete product\n3.To change product's name"
					+ "\n4.To change product's units\n5.To change product's price\n6.To change product's category\n7.To exit");
			int cf=sc.nextInt();
			switch(cf) {
			case 1:
				try {
					System.out.println("Enter the name of the product: ");
				    String nam=sc.next();
				    System.out.println("Enter the units of the product: ");
				    int in=sc.nextInt();
				    System.out.println("Enter the price of the product: ");
				    double dou=sc.nextDouble();
				    System.out.println("Enter the category of the product: ");
				    String cat=sc.next();
					ps=con.prepareStatement("insert into Product(Pname,Punits,Pprice,Pcategory)values(?,?,?,?)");
					ps.setString(1,nam);
					ps.setInt(2,in);
					ps.setDouble(3, dou);
					ps.setString(4,cat);
					int q=ps.executeUpdate();
					if(q>0) {
						System.out.println("Product Successfully added in the stock!!");
						navigation2(did,c);
					}
					else {
						System.out.println("SOMETHING WENT WRONG!!!");
						navigation2(did,c);
					}
					
				}
				catch(Exception eo) {
					eo.printStackTrace();				
					}
				break;
			case 2: 
				try {
					System.out.println("Enter id of the product to delete the particular product: ");
					int i=sc.nextInt();
					ps=con.prepareStatement("delete  from Product where ProductID=? ");
					ps.setInt(1, i);
					int q=ps.executeUpdate();
					if(q>0) {
						System.out.println("Product Successfully deleted from the stock!!");
						navigation2(did,c);
					}
					else {
						System.out.println("SOMETHING WENT WRONG!!!");
						navigation2(did,c);
					}
					
				}
				catch(Exception eo) {
					eo.printStackTrace();				
					}
				break;
			case 3:
				try {
					System.out.println("Enter id of the product to change the particular product's name: ");
					int i=sc.nextInt();
					System.out.println("Enter new name of the product: ");
					String na=sc.next();
					ps=con.prepareStatement("update Product set Pname=? where ProductID=? ");
					ps.setString(1, na);
					ps.setInt(2, i);
					int q=ps.executeUpdate();
					if(q>0) {
						System.out.println("Product's name changed Successfully!!");
						navigation2(did,c);
					}
					else {
						System.out.println("SOMETHING WENT WRONG!!!");
						navigation2(did,c);
					}
				}
				catch(Exception eo) {
					eo.printStackTrace();				
					}
				break;
			case 4:
				try {
					System.out.println("Enter id of the product to change the particular product's units: ");
					int i=sc.nextInt();
					System.out.println("Enter new units of the product: ");
					int na=sc.nextInt();
					ps=con.prepareStatement("update Product set Punits=? where ProductID=? ");
					ps.setInt(1, na);
					ps.setInt(2, i);
					int q=ps.executeUpdate();
					if(q>0) {
						System.out.println("Product's units changed Successfully!!");
						navigation2(did,c);
					}
					else {
						System.out.println("SOMETHING WENT WRONG!!!");
						navigation2(did,c);
					}

				}
				catch(Exception eo) {
					eo.printStackTrace();				
					}
				break;
			case 5:
				try {
					System.out.println("Enter id of the product to change the particular product's price: ");
					int i=sc.nextInt();
					System.out.println("Enter new price of the product: ");
					double na=sc.nextDouble();
					ps=con.prepareStatement("update Product set Pprice=? where ProductID=? ");
					ps.setDouble(1, na);
					ps.setInt(2, i);
					int q=ps.executeUpdate();
					if(q>0) {
						System.out.println("Product's price changed Successfully!!");
						navigation2(did,c);
					}
					else {
						System.out.println("SOMETHING WENT WRONG!!!");
						navigation2(did,c);
					}
				}
				catch(Exception eo) {
					eo.printStackTrace();				
					}
				break;
			case 6:
				try {
					System.out.println("Enter id of the product to change the particular product's category: ");
					int i=sc.nextInt();
					System.out.println("Enter new category of the product: ");
					String na=sc.next();
					ps=con.prepareStatement("update Product set Pcategory=? where ProductID=? ");
					ps.setString(1, na);
					ps.setInt(2, i);
					int q=ps.executeUpdate();
					if(q>0) {
						System.out.println("Product's category changed Successfully!!");
						navigation2(did,c);
					}
					else {
						System.out.println("SOMETHING WENT WRONG!!!");
						navigation2(did,c);
					}
				}
				catch(Exception eo) {
					eo.printStackTrace();				
					}
				break;
			case 7:
				ef.exit();
				break;
			default:
				System.out.println("Enter valid Input!!");
				navigation2(did,c);
			}
			
		}
		else {
			System.out.println("Enter valid input!!");
		}
	}
	
	
	public void userLogin(int did,int c) {
		
		System.out.println("1.To Change the Account Details\n2.Products\n3.Cart\n4.Orders");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("1.To update your name\n2.To update your number\n3.To update your email\n4.To update your password ");
			int chi=sc.nextInt();
			switch(chi) {
			case 1:
				System.out.println("Enter your new name: ");
				String nu=sc.next();
				try {
					ps=con.prepareStatement("update User set Cname=? where CustomerID=? ");
					ps.setString(1, nu);
					ps.setInt(2, did);
					int x=ps.executeUpdate();
					if(x>0) {
						System.out.println("Your name is updated successfully");
						navigation2(did,c);
					}
					else {
						System.out.println("Something went wrong");
						navigation2(did,c);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter your new number: ");
				String n=sc.next();
				try {
					ps=con.prepareStatement("update User set Cnumber=? where CustomerID=? ");
					ps.setString(1, n);
					ps.setInt(2, did);
					int x=ps.executeUpdate();
					if(x>0) {
						System.out.println("Your number is updated successfully");
						navigation2(did,c);
					}
					else {
						System.out.println("Something went wrong");
						navigation2(did,c);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter your new email: ");
				String nn=sc.next();
				try {
					ps=con.prepareStatement("update User set Cemail=? where CustomerID=? ");
					ps.setString(1, nn);
					ps.setInt(2, did);
					int x=ps.executeUpdate();
					if(x>0) {
						System.out.println("Your email is updated successfully");
						navigation2(did,c);
					}
					else {
						System.out.println("Something went wrong");
						navigation2(did,c);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter your new password: ");
				String nm=sc.next();
				try {
					ps=con.prepareStatement("update User set Cpassword=? where CustomerID=? ");
					ps.setString(1, nm);
					ps.setInt(2, did);
					int x=ps.executeUpdate();
					if(x>0) {
						System.out.println("Your password is updated successfully");
						navigation2(did,c);
					}
					else {
						System.out.println("Something went wrong");
						navigation2(did,c);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Enter valid input!!");
				navigation2(did,c);
			}
			
			break;
		case 2:
			products(did);
			
			break;
		case 3:
			try {
			ps=con.prepareStatement("select * from Cart where CustomerID=?");
			ps.setInt(1, did);
			ResultSet rs=ps.executeQuery();
			int i;
			double lastp=0;
			String na;
			int un;
			double u;
			String ca;
			Cart cp;
			Order op;
		    if(rs.first()==false) {
		    	System.out.println("Cart is Empty!!");
				navigation2(did,c);
		    }
			  else {
				  rs.beforeFirst();
					while(rs.next()) {
						i=rs.getInt("ProductID");
						na=rs.getString("Pname");
						un=rs.getInt("Punits");
						u=rs.getDouble("Pprice");
						lastp+=u;
						ca=rs.getString("Pcategory");
						cp=new Cart(did,i,na,un,u,ca);
						System.out.println(cp.toString());
					}
					
					System.out.println("\nWant to buy now?(yes/no) : \n");
					String ye="yes",y=sc.next();
					if(y.equalsIgnoreCase(ye)) {
						System.out.println("Do you want to buy all the products from cart? (yes/no)");
						String yup=sc.next();
						if(yup.equalsIgnoreCase(ye)) {
							ps=con.prepareStatement("select * from Cart where CustomerID=?");
							ps.setInt(1, did);
							ResultSet s=ps.executeQuery();
						  op=c2.necessary(did);
						  int r=-1;
						  while(s.next()) {
							  i=s.getInt("ProductID");
							  na=s.getString("Pname");
							  un=s.getInt("Punits");
							  u=s.getDouble("Pprice");
							  lastp+=u;
							  ca=s.getString("Pcategory");
							  cp=new Cart(did,i,na,un,u,ca);
							  c2.buynow(did, op, lastp,cp);
							  ps=con.prepareStatement("delete from Cart where CustomerID=? and ProductID=?");
							  ps.setInt(1, did);
							  ps.setInt(2, i);
							  r=ps.executeUpdate();
						  }
						
						if(r>-1) {
							System.out.println("ORDER PLACED SUCCESSFULLY!!!");
						}
						else {System.out.println("Cart cannot get empty!!");}
					}
						
					else {
							System.out.println("Enter how many products you want buy now?");
							int pro=sc.nextInt();
							op=c2.necessary(did);
							c2.toaddRemove(pro, did, op);
					
					navigation2(did,c);
					}
					
				}
					navigation2(did,c);
		
				}
			  
			
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				ps=con.prepareStatement("select * from Orders where CustomerID=?");
				ps.setInt(1, did);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					String na=rs.getString("Caddress");
					Date d=rs.getDate("OrderDate");
					Date d2=(java.sql.Date)rs.getDate("DeliveryDate");
					String pp=rs.getString("PaymentOp");
					int p=rs.getInt("ProductID");
					String aa=rs.getString("Pname");
					int vn=rs.getInt("Punits");
					double dp=rs.getDouble("Pprice");
					String sq=rs.getString("Pcategory");
					Order op=new Order(did,na,d,d2,pp,p,aa,vn,dp,sq);
					System.out.println(op.toString());
				}
				navigation2(did,c);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Enter valid input!!");
			navigation2(did,c);
		}
	}

}
