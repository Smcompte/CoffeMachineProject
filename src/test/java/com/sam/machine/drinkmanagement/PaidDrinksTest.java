package com.sam.machine.drinkmanagement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PaidDrinksTest {
	
	PaidDrinks paidDrinks;
	
    @Before
    public void setUp() throws Exception {
    	paidDrinks = new PaidDrinks();
    }
    
    @Test
    public void testPaidDrinksMachine() {
    	assertNotNull(paidDrinks.serveCustomer("Chocolate", 0, 0.5));
    	assertTrue(paidDrinks.serveCustomer("Chocolate", 0, 0.5).equals("H::"));
    	assertTrue(paidDrinks.serveCustomer("Chocolate", 1, 0.5).equals("H:1:0"));
    	assertTrue(paidDrinks.serveCustomer("Coffee", 2, 0.6).equals("C:2:0"));
    	assertTrue(paidDrinks.serveCustomer("Tea", 0, 0.4).equals("T::"));
    	assertTrue(paidDrinks.serveCustomer("Tea", 1, 0.4).equals("T:1:0"));
    	assertTrue(paidDrinks.serveCustomer("Chocolate", 1, 0.4).contains("Missing money"));
    	assertTrue(paidDrinks.serveCustomer("Coffee", 1, 0.4).contains("Missing money"));
    	assertTrue(paidDrinks.serveCustomer("Tea", 1, 0.3).contains("Missing money"));
    	assertTrue(paidDrinks.serveCustomer("Chocolate", 1, 0.4).contains(" Missing money : 0.1"));
    	assertTrue(paidDrinks.serveCustomer("Coffee", 1, 0.4).contains(" Missing money : 0.2"));
    	assertTrue(paidDrinks.serveCustomer("Tea", 1, 0.36).contains(" Missing money : 0.04"));
    }

}
