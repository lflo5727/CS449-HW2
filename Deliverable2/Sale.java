package Deliverable2;

import java.util.ArrayList;
import Deliverable2.Item;

public class Sale {
	
	private static double DISCOUNT_RATE = 0.05;
	private static double SENIOR_DISCOUNT_RATE = 0.10;
	private static double PREFERRED_DISCOUNT_RATE = 0.15;
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	private String customerType;
	
	public Sale(String cType) {
		this.customerType = cType;
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	public double getDiscountRate() {
		switch(customerType) {
			case "standard":
				return DISCOUNT_RATE;
			case "senior":
				return SENIOR_DISCOUNT_RATE;
			case "preferred":
				return PREFERRED_DISCOUNT_RATE;
			default:
				return 0.0;
		}
		
	}
	
	public double getDiscount() {
		return getSubTotal()*getDiscountRate();
	}
	
	public double getSubTotal() {
		double subTotal = 0.0;
		for (Item item: itemList) {
			subTotal += item.getItemTotal();
		}
		return subTotal;
	}
	
	public double getDiscountedSubTotal() {
		return getSubTotal() - getDiscount();
	}
	
	public String getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(String cType) {
		this.customerType = cType;
	}
}