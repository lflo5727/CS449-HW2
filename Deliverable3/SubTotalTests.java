package Deliverable3;

import junit.framework.TestCase;
import Deliverable3.Sale;
import Deliverable3.Item;

public class SubTotalTests extends TestCase{
	
	public void testBasicSubtotal() {
		Sale testSale = new Sale("standard", "F");
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getSubTotal(), 67.0);
	}
	
	public void testZeroItems() {
		Sale testSale = new Sale("standard", "W");
		
		assertEquals(testSale.getSubTotal(), 0.0);
		
	}
	
	public void testFreeItems() {
		Sale testSale = new Sale("standard", "M");
		Item starch = new Item("Potato", 0.0, 1);
		Item movie = new Item("Iron Giant", 0.0, 1);
		
		testSale.addItem(starch);
		testSale.addItem(movie);
		
		assertEquals(testSale.getSubTotal(), 0.0);
		
	}
	
	public void testSenior() {
		Sale testSale = new Sale("senior", "Tu");
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getSubTotal(), 50.0);
	}
	
	public void testPreferred() {
		Sale testSale = new Sale("preferred", "Th");
		Item uselessBrandName = new Item("useless brand name", 100.00, 2);
		
		testSale.addItem(uselessBrandName);
		
		assertEquals(testSale.getSubTotal(), 200.00);
	}
}