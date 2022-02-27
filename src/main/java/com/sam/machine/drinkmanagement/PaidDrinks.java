package com.sam.machine.drinkmanagement;

import com.sam.machine.enums.Drink;

public class PaidDrinks {
	
	public String serveCustomer(String choiceOfCustomer, int nbSugar, Double moneyIntroduced) {
		
		String drinkCode = null;
		
		StringBuffer forDrinkMaker = new StringBuffer();
		
		try {
			
			Drink selectedDrink = Drink.valueOf(choiceOfCustomer);
			drinkCode = selectedDrink.getDrinkCode();
			Double drinkPrice = selectedDrink.getPrice();
			
			if (moneyIntroduced < drinkPrice) {
				Double moneyMissing = drinkPrice - moneyIntroduced ;
				return forDrinkMaker.append("M:{" + " Missing money : " +  Math.round(moneyMissing*100.0)/100.0 + "}").toString();
			}
			
			switch (nbSugar) {
			case 0:
				
				forDrinkMaker.append(drinkCode + ":" + ":");
			
				break;

			default:
			
				forDrinkMaker.append(drinkCode + ":" + nbSugar + ":" +"0");
				
				break;
			}
			
			return forDrinkMaker.toString();
			
		} catch (Exception e) {
			
			if (drinkCode == null) {
				return forDrinkMaker.append("M:{" + " Unknown drink code : " + choiceOfCustomer + "}").toString();
			} else {
				return forDrinkMaker.append("M:{" + " Input error : " + e.getMessage() + "}").toString();
			}
			
		}
		
	}

}
