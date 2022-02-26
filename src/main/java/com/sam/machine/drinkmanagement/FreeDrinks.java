package com.sam.machine.drinkmanagement;

import com.sam.machine.enums.Drink;

public class FreeDrinks {

	public String serveCustomer(String choiceOfCustumer, int nbSugar) {
		
		String drinkCode = null;
		
		StringBuffer forDrinkMaker = new StringBuffer();
		
		try {
			
			drinkCode = Drink.valueOf(choiceOfCustumer).getDrinkCode();

			if (nbSugar == 0) {

				forDrinkMaker.append(drinkCode + ":" + ":");

			} else {

				forDrinkMaker.append(drinkCode + ":" + nbSugar + ":" +"0");
			}

			return forDrinkMaker.toString();

			
		} catch (Exception e) {
			
			if (drinkCode == null) {
				return forDrinkMaker.append("M:{" + " Unknown drink code : " + choiceOfCustumer+"}").toString();
			} else {
				return forDrinkMaker.append("M:{" + " Input error : " + e.getMessage() + "}").toString();
			}
			
		}

	}


}
