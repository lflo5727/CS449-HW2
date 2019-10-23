package Deliverable1;

import junit.framework.TestCase;
import Deliverable1.Sale;
import Deliverable1.Item;

public class SubTotalTests extends TestCase{
	
	public void testBasicSubtotal() {
		Sale testSale = new Sale();
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getSubTotal(), 67.0);
	}
	
	public void testZeroItems() {
		Sale testSale = new Sale();
		
		assertEquals(testSale.getSubTotal(), 0.0);
		
	}
	
	public void testFreeItems() {
		Sale testSale = new Sale();
		Item starch = new Item("Potato", 0.0, 1);
		Item movie = new Item("Iron Giant", 0.0, 1);
		
		testSale.addItem(starch);
		testSale.addItem(movie);
		
		assertEquals(testSale.getSubTotal(), 0.0);
		
	}
}