package Pojo;

import java.util.ArrayList;

public class User {
	
	private String customerName;
	private String password;
	private String email;
	private String pnumber;


	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber=pnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User(String customerName, String pnumber, String email, String password) {
		super();
		this.customerName = customerName;
		this.password = password;
		this.email = email;
		this.pnumber = pnumber;
		
	}
	public User() {
		super();
	}
	
	
	@Override
	public String toString() {
		return ", CustomerName=" + customerName + ", Password =" + password + ", EmailID =" + email + ", Number ="
				+ pnumber + "]";
	}
	
	
	
	
	
	

}
