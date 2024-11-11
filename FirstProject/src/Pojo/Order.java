package Pojo;

import java.util.Date;

public class Order {

	private int CustomerID;
	private String Caddress;
	private Date OrderDate;
	private Date DeliveryDate;
	private String PaymentOp;
	private int pid;
	private String pname;
	private int punits;
	private double pprice;
	private String pcategory;
	
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCaddress() {
		return Caddress;
	}
	public void setCaddress(String caddress) {
		Caddress = caddress;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public String getPaymentOp() {
		return PaymentOp;
	}
	public void setPaymentOp(String paymentOp) {
		PaymentOp = paymentOp;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPunits() {
		return punits;
	}
	public void setPunits(int punits) {
		this.punits = punits;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public Order() {
		super();
	}
	
	public Order(int customerID, String caddress, Date orderDate, Date deliveryDate, String paymentOp, int pid,
			String pname, int punits, double pprice, String pcategory) {
		super();
		CustomerID = customerID;
		Caddress = caddress;
		OrderDate = orderDate;
		DeliveryDate = deliveryDate;
		PaymentOp = paymentOp;
		this.pid = pid;
		this.pname = pname;
		this.punits = punits;
		this.pprice = pprice;
		this.pcategory = pcategory;
	}
	public Order(int customerID, String caddress, Date orderDate, Date deliveryDate, String paymentOp) {
		super();
		CustomerID = customerID;
		Caddress = caddress;
		OrderDate = orderDate;
		DeliveryDate = deliveryDate;
		PaymentOp = paymentOp;
	}
	@Override
	public String toString() {
		return "Order [CustomerID=" + CustomerID + ", Caddress=" + Caddress + ", OrderDate=" + OrderDate
				+ ", DeliveryDate=" + DeliveryDate + ", PaymentOp=" + PaymentOp + ", pid=" + pid + ", pname=" + pname
				+ ", punits=" + punits + ", pprice=" + pprice + ", pcategory=" + pcategory + "]";
	}
	
	


}
