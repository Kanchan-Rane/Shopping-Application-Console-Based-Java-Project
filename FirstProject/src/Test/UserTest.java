package Test;


import java.util.Scanner;
import DaoImplementation.DaoImpl1;
import DaoImplementation.DaoImpl2b;
import Helper.Connect;
import Pojo.User;


public class UserTest {
	
	Scanner sc=Connect.getInput();
	static int choiceimp;
	DaoImpl2b qw=new DaoImpl2b();
	
	public void homepage(int id,int choice) {
		System.out.println("\nHOMEPAGE\n\n");
		if(choice==3||choice==4) {
			qw.adminMenu(id,choice);
		}
		else {
			qw.userLogin(id,choice);
		}
	
	}
	
	
	public static void main(String[] args) {
		UserTest u1=new UserTest();
		DaoImpl1 di=new DaoImpl1();
		Scanner sc=Connect.getInput();
		System.out.println(" WELCOME \n");
		System.out.println(" 1.Create Account \n 2.Login Account \n 3.Create AdminAccount \n 4.AdminLogin Account");
		int choice=sc.nextInt();
		choiceimp=choice;
		
		if(choice==1 || choice==3) {
			
			System.out.println("Enter your Name: ");
			String name=sc.next();
			System.out.println("Enter your Phone number: ");
			String Pnumber=sc.next();
			System.out.println("Enter your EmailID: ");
			String email=sc.next();
			System.out.println("Enter your Password: ");
		    String password=sc.next();
		    User u=new User(name,Pnumber,email,password);
		    
		    if(di.createAccount(u)) {
		    	
		    	if(di.createAdmin(name)) {
		    		System.out.println("ADMIN ACCOUNT CREATED SUCCESSFULLY!!!!\\n");
		    		choice=3;
		    	}
		    	else {
		    	System.out.println("ACCOUNT CREATED SUCCESSFULLY!!!!\n");
		    	choice=1;
		    	}
		    	int id=di.userLogin(Pnumber, password);
		    	u1.homepage(id,choice);
		    	}
		    else{
		    	System.out.println("SOMETHING WENT WRONG ...ACCOUNT IS NOT CREATED");
		    }
		    
		}
		else if(choice==4 || choice==2) {
			
			System.out.println("\nEnter your name: ");
			String na=sc.next();
			if(di.loginAdmin(na)) {
				choice=4;
				System.out.println("\nWELCOME ADMIN\n");
			}
			else {
				choice=2;
			}
			System.out.println("Enter your Phone number: ");
			String Pnumber=sc.next();
			System.out.println("Enter your Password: ");
			String password=sc.next();
			int id=di.userLogin(Pnumber, password);
			if(id!=-1) {
				System.out.println("Login Successfully!!!!\n");
				u1.homepage(id,choice);
			}
			else {
				System.out.println("SOMETHING WENT WRONG ...");
			}
			
		}
		
		
		
		
	}

}
