package Deliverable5;

import junit.framework.TestCase;
import Deliverable5.Sale;
import Deliverable5.Item;

public class SubTotalTests extends TestCase{
	
	public void testBasicSubtotal() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getSubTotal(), 67.0);
	}
	
	public void testZeroItems() {
		Sale testSale = new Sale(new Standard(), new Tuesday());
		
		assertEquals(testSale.getSubTotal(), 0.0);
		
	}
	
	public void testFreeItems() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item starch = new Item("Potato", 0.0, 1);
		Item movie = new Item("Iron Giant", 0.0, 1);
		
		testSale.addItem(starch);
		testSale.addItem(movie);
		
		assertEquals(testSale.getSubTotal(), 0.0);
		
	}
	
	public void testSenior() {
		Sale testSale = new Sale(new Senior(), new Tuesday());
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getSubTotal(), 50.0);
	}
	
	public void testPreferred() {
		Sale testSale = new Sale(new Preferred(), new NotTuesday());
		Item uselessBrandName = new Item("useless brand name", 100.00, 1);
		
		testSale.addItem(uselessBrandName);
		
		assertEquals(testSale.getSubTotal(), 100.00);
	}
	
	public void testLargeQuantityDiscount() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item socks = new Item("Socks", 4.0, 5);
		
		testSale.addItem(socks);
		
		assertEquals(testSale.getSubTotal(), 12.0);
		
	}
}