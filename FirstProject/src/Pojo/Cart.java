package Pojo;

public class Cart {

	private int cid;
	private int pid;
	private String pname;
	private int punits;
	private double pprice;
	private String pcategory;
	
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
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

	public Cart(int cid, int pid, String pname, int punits, double pprice, String pcategory) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.pname = pname;
		this.punits = punits;
		this.pprice = pprice;
		this.pcategory = pcategory;
	}


	public Cart() {
		super();
	}


	@Override
	public String toString() {
		return "Cart ["+" ProductID=" + pid + ", Name=" + pname + ", Units=" + punits + ", Price=" + pprice
				+ ", Category=" + pcategory + "]";
	}
	


}
