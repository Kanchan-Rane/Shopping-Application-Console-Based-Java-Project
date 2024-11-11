package DaoImplementation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import Helper.Connect;
import Pojo.Cart;
import Pojo.Order;

public class DaoImpl2c{

	static Connection con=Connect.getConnection();
	static Scanner sc=Connect.getInput();
	PreparedStatement ps;
//	DaoImpl2c c2=new DaoImpl2c();
	

	public boolean buynow(int cid,Order o,double lastp,Cart c) {
		try {
			ps=con.prepareStatement("insert into Orders(CustomerID,Caddress,OrderDate,DeliveryDate,PaymentOp,"
					+ "ProductID,Pname,Punits,Pprice,Pcategory)values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,cid);
			ps.setString(2,o.getCaddress());
			ps.setDate(3,(java.sql.Date) o.getOrderDate());
			ps.setDate(4,(java.sql.Date) o.getDeliveryDate());
			ps.setString(5,o.getPaymentOp());
			ps.setInt(6,c.getPid());
			ps.setString(7,c.getPname());
			ps.setInt(8,c.getPunits());
			ps.setDouble(9,c.getPprice());
			ps.setString(10,c.getPcategory());
			int in=ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("select Punits from Product where ProductID=?");
			ps1.setInt(1, c.getPid());
			ResultSet q=ps1.executeQuery();
			int exists=0;
			while(q.next()) {
				exists=q.getInt("Punits");
			}
			exists=exists-c.getPunits();
			PreparedStatement ps2=con.prepareStatement("update Product set Punits=? where ProductID=?");
			ps2.setInt(1, exists);
			ps2.setInt(2, c.getPid());
			int in1=ps2.executeUpdate();
			check(cid);
			if(in>0 && in1>0) {
				
				return true;
			}else {return false;}
			
		}
		catch(Exception en) {
			en.printStackTrace();
		}
		
		return false;
	}
	
	public Order necessary(int cid)
	{
		System.out.println("Enter your Address: ");
		String ad=sc.nextLine();
		System.out.println();
		System.out.println("How do you like to do your payment \n1.COD\n2.Debit Card\n3.Credit Card\n4.UPI\n");
		int i=sc.nextInt();
		String pay="COD";
		switch(i) {
		case 1:
			pay="COD";
			break;
		case 2:
			pay="Debit Card";
			break;
		case 3:
			pay="Credit Card";
			break;
		case 4:
			pay="UPI";
			break;
		}
		LocalDate order = LocalDate.now();
		Date dI= java.sql.Date.valueOf(order);
		Date p=java.sql.Date.valueOf(order.plusDays(10));
		Order o=new Order(cid,ad,dI,p,pay);
		return o;
	}
	
	public void toaddRemove(int pr,int did,Order op){
		
		try {
			for(int l=1;l<=pr;l++) {
				System.out.println("Enter ID's of the product: \n");
			    int po=sc.nextInt();
			    ps=con.prepareStatement("select * from Cart where CustomerID=? and ProductID=?");
				ps.setInt(1, did);
				ps.setInt(2, po);
				ResultSet s=ps.executeQuery();
				 while(s.next()) {
					  int i=s.getInt("ProductID");
					  String na=s.getString("Pname");
					  int un=s.getInt("Punits");
					  double u=s.getDouble("Pprice");
					  String ca=s.getString("Pcategory");
					  Cart cp=new Cart(did,i,na,un,u,ca);
					  buynow(did, op, u,cp);
				  }
				 
				PreparedStatement ps1;
				ps1=con.prepareStatement("delete from Cart where CustomerID=? and ProductID=?");
				ps1.setInt(1, did);
				ps1.setInt(2, po);
				ps1.executeUpdate();
				
			}
			System.out.println("ORDER PLACED SUCCESSFULLY!!!");
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void check(int cid) {
		try {
			ArrayList<Integer> al=new ArrayList<Integer>();
			ps=con.prepareStatement("select * from Orders where CustomerID=?");
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			LocalDate d=LocalDate.now();
			Date d1=Date.valueOf(d);
			while(rs.next()) {
				int pid=rs.getInt("ProductID");
				Date dd=rs.getDate("DeliveryDate");
				if(d1.compareTo(dd)>0) {
					al.add(pid);
				}
			}
			if(al.size()!=0) {
				for (Integer element : al) {
		            int num=element.intValue();
		            PreparedStatement ps1;
					ps1=con.prepareStatement("delete from Orders where CustomerID=? and ProductID=?");
					ps1.setInt(1, cid);
					ps1.setInt(2, num);
					ps1.executeUpdate();
		        }
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
 

}
