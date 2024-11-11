package Dao;

import Pojo.Products;
import Pojo.User;

public interface All {
	boolean createAdmin(String cname);
	boolean loginAdmin(String cname);
	boolean createAccount(User u); 
	int userLogin(String pnumber, String password); 
	
	
}


	
