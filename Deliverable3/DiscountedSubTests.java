package Deliverable3;

import junit.framework.TestCase;
import Deliverable3.Sale;
import Deliverable3.Item;

public class DiscountedSubTests extends TestCase{
	
	public void testBasicSale() {
		Sale testSale = new Sale("standard", "M");
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getDiscountedSubTotal(), 63.65);
	}
	
	public void testNoItems() {
		Sale testSale = new Sale("standard", "Th");
		
		assertEquals(testSale.getDiscountedSubTotal(), 0.0);
	}
	
	public void testSenior() {
		Sale testSale = new Sale("senior", "Tu");
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getDiscountedSubTotal(), 45.0);
	}
	
	public void testPreferred() {
		Sale testSale = new Sale("preferred", "W");
		Item uselessBrandName = new Item("useless brand name", 100.00, 2);
		
		testSale.addItem(uselessBrandName);
		
		assertEquals(testSale.getDiscountedSubTotal(), 170.00);
	}
	
	public void testSeniorWrongDay() {
		Sale testSale = new Sale("senior", "F");
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getDiscountedSubTotal(), 47.5);
	}
}