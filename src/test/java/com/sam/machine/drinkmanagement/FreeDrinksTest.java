package com.sam.machine.drinkmanagement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FreeDrinksTest {
	
	FreeDrinks freeDrinks;
	
    @Before
    public void setUp() throws Exception {
    	freeDrinks = new FreeDrinks();
    }
    
    @Test
    public void testFreeDrinksMachine() {
    	assertNotNull(freeDrinks.serveCustomer("Chocolate", 0));
    	assertTrue(freeDrinks.serveCustomer("Chocolate", 0).equals("H::"));
    	assertTrue(freeDrinks.serveCustomer("Chocolate", 1).equals("H:1:0"));
    	assertTrue(freeDrinks.serveCustomer("Coffee", 2).equals("C:2:0"));
    	assertTrue(freeDrinks.serveCustomer("Tea", 0).equals("T::"));
    	assertTrue(freeDrinks.serveCustomer("Tea", 1).equals("T:1:0"));
    	assertTrue(freeDrinks.serveCustomer("Limonade", 1).contains("Unknown drink code"));
    }

}
