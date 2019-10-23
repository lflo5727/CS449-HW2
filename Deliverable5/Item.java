package Deliverable5;


public class Item  {
	private String title;
	private double unitPrice;
	private int quantity;
	
	public Item(String title, double unitPrice, int quantity) {
		super();
		this.title = title;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double newPrice) {
		this.unitPrice = newPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int newQuan) {
		this.quantity = newQuan;
	}
	
	public double getItemTotal() {
		return this.unitPrice * this.quantity;
	}
}