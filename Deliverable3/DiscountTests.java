package Deliverable3;

import junit.framework.TestCase;
import Deliverable3.Sale;
import Deliverable3.Item;

public class DiscountTests extends TestCase{
	
	public void testBasicSale() {
		Sale testSale = new Sale("standard", "Su");
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getDiscount(), 3.35);
	}
	
	public void testNoItems() {
		Sale testSale = new Sale("standard", "Sa");
		
		assertEquals(testSale.getDiscount(), 0.0);
	}
	
	public void testFreeItems() {
		Sale testSale = new Sale("standard", "M");
		Item trashFromTheFloor = new Item("Trash off the floor", 0.0, 1);
		
		testSale.addItem(trashFromTheFloor);
		assertEquals(testSale.getDiscount(), 0.0);
	}
	
	public void testSenior() {
		Sale testSale = new Sale("senior", "Tu");
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getDiscount(), 5.0);
	}
	
	public void testPreferred() {
		Sale testSale = new Sale("preferred", "F");
		Item uselessBrandName = new Item("useless brand name", 100.00, 2);
		
		testSale.addItem(uselessBrandName);
		
		assertEquals(testSale.getDiscount(), 30.00);
	}
	
	public void testSeniorWrongDay() {
		Sale testSale = new Sale("senior", "F");
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
	
		assertEquals(testSale.getDiscount(), 2.5);
	}
	
}