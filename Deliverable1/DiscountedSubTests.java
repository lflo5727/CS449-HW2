package Deliverable1;

import junit.framework.TestCase;
import Deliverable1.Sale;
import Deliverable1.Item;

public class DiscountedSubTests extends TestCase{
	
	public void testBasicSale() {
		Sale testSale = new Sale();
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getDiscountedSubTotal(), 63.65);
	}
	
	public void testNoItems() {
		Sale testSale = new Sale();
		
		assertEquals(testSale.getDiscountedSubTotal(), 0.0);
	}
}