package Deliverable4;

import java.util.ArrayList;
import Deliverable4.Item;

public class Sale {
	
	private static double DISCOUNT_RATE = 0.05;
	private static double SENIOR_DISCOUNT_RATE = 0.10;
	private static double PREFERRED_DISCOUNT_RATE = 0.15;
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	private DiscountType customerType;
	private DaySale dayOfTheWeek;
	
	public Sale(DiscountType cType, DaySale day) {
		this.customerType = cType;
		this.dayOfTheWeek = day;
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	public static double getStandardRate() {
		return DISCOUNT_RATE;
	}
	
	public static double getSenioRate() {
		return SENIOR_DISCOUNT_RATE;
	}
	
	public static double getPreferredRate() {
		return PREFERRED_DISCOUNT_RATE;
	}
	
	
	public double getDiscountRate(DiscountType dT) {
		return dT.getDiscount(this.dayOfTheWeek);
	}
	
	public double getDiscount() {
		return getSubTotal()*getDiscountRate(customerType);
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
	
	public DiscountType getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(DiscountType cType) {
		this.customerType = cType;
	}
	
	public DaySale getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	
	public void setDayOfTheWeek(DaySale day) {
		this.dayOfTheWeek = day;
	}
}

//Class setup to replace Discount Switch
abstract class DiscountType{
	abstract double getDiscount(DaySale today);
}

class Standard extends DiscountType{
	double getDiscount(DaySale today) {
		return Sale.getStandardRate();
	}
}

class Senior extends DiscountType{
	double getDiscount(DaySale today) {
		return today.getSeniorRate();
	}
	
}

class Preferred extends DiscountType{
	double getDiscount(DaySale today) {
		return Sale.getPreferredRate();
	}
}

//Class setup to replace day of the week switch statement
abstract class DaySale{
	abstract double getSeniorRate();
}

class Tuesday extends DaySale{
	double getSeniorRate() {
		return Sale.getSenioRate();
	}
}

class NotTuesday extends DaySale{
	double getSeniorRate() {
		return Sale.getStandardRate();
	}
}

