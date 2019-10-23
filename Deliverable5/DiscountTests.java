package Deliverable5;

import junit.framework.TestCase;
import Deliverable5.Sale;
import Deliverable5.Item;

public class DiscountTests extends TestCase{
	
	public void testBasicSale() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item brush = new Item("brush", 7.0, 1);
		Item game = new Item("Halo 3", 60.0, 1);
		
		testSale.addItem(brush);
		testSale.addItem(game);
		
		assertEquals(testSale.getDiscount(), 3.35);
	}
	
	public void testNoItems() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		
		assertEquals(testSale.getDiscount(), 0.0);
	}
	
	public void testFreeItems() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item trashFromTheFloor = new Item("Trash off the floor", 0.0, 1);
		
		testSale.addItem(trashFromTheFloor);
		assertEquals(testSale.getDiscount(), 0.0);
	}
	
	public void testSenior() {
		Sale testSale = new Sale(new Senior(), new Tuesday());
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
		
		assertEquals(testSale.getDiscount(), 5.0);
	}
	
	public void testPreferred() {
		Sale testSale = new Sale(new Preferred(), new NotTuesday());
		Item uselessBrandName = new Item("useless brand name", 100.00, 1);
		
		testSale.addItem(uselessBrandName);
		
		assertEquals(testSale.getDiscount(), 15.00);
	}
	
	public void testSeniorWrongDay() {
		Sale testSale = new Sale(new Senior(), new NotTuesday());
		Item dentures = new Item("dentures", 50.0, 1);
		
		testSale.addItem(dentures);
	
		assertEquals(testSale.getDiscount(), 2.5);
	}
	
	public void testLargeQuantityDiscount() {
		Sale testSale = new Sale(new Standard(), new NotTuesday());
		Item socks = new Item("Socks", 4.0, 5);
		
		testSale.addItem(socks);
		
		assertEquals(testSale.getDiscount(), 0.6000000000000001);
		
	}
	
}