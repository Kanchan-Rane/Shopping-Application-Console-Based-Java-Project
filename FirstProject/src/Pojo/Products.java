package Pojo;

public class Products {
	
	private int ProductID;
	private String Pname;
	private int Punits;
	private double Pprice;
	private String Pcategory;
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public int getPunits() {
		return Punits;
	}
	public void setPunits(int punits) {
		Punits = punits;
	}
	public double getPprice() {
		return Pprice;
	}
	public void setPprice(double pprice) {
		Pprice = pprice;
	}
	public String getPcategory() {
		return Pcategory;
	}
	public void setPcategory(String pcategory) {
		Pcategory = pcategory;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	
	
	public Products(int productID, String pname, int punits, double pprice, String pcategory) {
		super();
		this.ProductID = productID;
		this.Pname = pname;
		this.Punits = punits;
		this.Pprice = pprice;
		this.Pcategory = pcategory;
	}
	
	
	public Products() {
		super();
	}
	@Override
	public String toString() {
		return "\nProducts [ProductID=" + ProductID + "| Name=" + Pname + "| Units=" + Punits + "| Price=" + Pprice
				+ "| Category=" + Pcategory + "]";
	}
	
	

	
	
	

}
