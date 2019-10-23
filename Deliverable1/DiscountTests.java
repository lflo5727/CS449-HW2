package Deliverable1;

import junit.framework.TestCase;
import Deliverable1.Sale;
import Deliverable1.Item;

public class DiscountTests extends TestCase{
	
	public void testBasicSale() {
		Sale testSale = new Sale();
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getDiscount(), 3.35);
	}
	
	public void testNoItems() {
		Sale testSale = new Sale();
		
		assertEquals(testSale.getDiscount(), 0.0);
	}
	
	public void testFreeItems() {
		Sale testSale = new Sale();
		Item trashFromTheFloor = new Item("Trash off the floor", 0.0, 1);
		
		testSale.addItem(trashFromTheFloor);
		assertEquals(testSale.getDiscount(), 0.0);
	}
	
	
}