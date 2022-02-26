package com.sam.machine.drinkmanagement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sam.machine.enums.Drink;

public class HotDrinksTest {
	
	HotDrinks hotDrink;
	
    @Before
    public void setUp() throws Exception {
    	hotDrink = new HotDrinks();
    }
    
    @Test
    public void testHotDrinkMachine() {
    	assertNotNull(hotDrink.serveCustomer("Chocolate", 0, 0.5, Drink.extraHotDrinkCode));
    	assertTrue(hotDrink.serveCustomer("Chocolate", 0, 0.5, Drink.extraHotDrinkCode).equals("Hh::"));
    	assertTrue(hotDrink.serveCustomer("Chocolate", 1, 0.5, "").equals("H:1:0"));
    	assertTrue(hotDrink.serveCustomer("Coffee", 2, 0.6, Drink.extraHotDrinkCode).equals("Ch:2:0"));
    	assertTrue(hotDrink.serveCustomer("Tea", 0, 0.4, Drink.extraHotDrinkCode).equals("Th::"));
    	assertTrue(hotDrink.serveCustomer("Tea", 1, 0.4, null).equals("T:1:0"));
    	assertTrue(hotDrink.serveCustomer("Chocolate", 1, 0.4, null).contains("Missing money"));
    	assertTrue(hotDrink.serveCustomer("Coffee", 1, 0.4, Drink.extraHotDrinkCode).contains("Missing money"));
    	assertTrue(hotDrink.serveCustomer("Tea", 1, 0.3, Drink.extraHotDrinkCode).contains("Missing money"));
    	assertTrue(hotDrink.serveCustomer("Chocolate", 1, 0.4, Drink.extraHotDrinkCode).contains(" Missing money : 0.1"));
    	assertTrue(hotDrink.serveCustomer("Coffee", 1, 0.4, Drink.extraHotDrinkCode).contains(" Missing money : 0.2"));
    	assertTrue(hotDrink.serveCustomer("Tea", 1, 0.36, Drink.extraHotDrinkCode).contains(" Missing money : 0.04"));
    }

}
