package Deliverable5;

import junit.framework.TestCase;
import Deliverable5.Sale;
import Deliverable5.Item;

public class DiscountedSubTests extends TestCase{
	
	public void testBasicSale() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getDiscountedSubTotal(), 63.65);
	}
	
	public void testNoItems() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		
		assertEquals(testSale.getDiscountedSubTotal(), 0.0);
	}
	
	public void testSenior() {
		Sale testSale = new Sale(new Senior(), new Tuesday());
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getDiscountedSubTotal(), 45.0);
	}
	
	public void testPreferred() {
		Sale testSale = new Sale(new Preferred(), new NotTuesday());
		Item uselessBrandName = new Item("useless brand name", 100.00, 1);
		
		testSale.addItem(uselessBrandName);
		
		assertEquals(testSale.getDiscountedSubTotal(), 85.00);
	}
	
	public void testSeniorWrongDay() {
		Sale testSale = new Sale(new Senior(), new NotTuesday());
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getDiscountedSubTotal(), 47.5);
	}
	
	public void testLargeQuantityDiscount() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item socks = new Item("Socks", 4.0, 5);
		
		testSale.addItem(socks);
		
		assertEquals(testSale.getDiscountedSubTotal(), 11.4);
		
	}
}