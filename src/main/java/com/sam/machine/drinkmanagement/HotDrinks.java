package com.sam.machine.drinkmanagement;

import com.sam.machine.enums.Drink;

public class HotDrinks {
	
	public String serveCustomer(String choiceOfCustumer, int nbSugar, Double moneyIntroduced, String drinkTemperature) {

		
		String drinkCode = null;
		
		StringBuffer forDrinkMaker = new StringBuffer();
		
		try {
			
			Drink selectedDrink = Drink.valueOf(choiceOfCustumer);
			drinkCode = selectedDrink.getDrinkCode();
			Double drinkPrice = selectedDrink.getPrice();
			
			if (moneyIntroduced < drinkPrice) {
				Double moneyMissing = drinkPrice - moneyIntroduced ;
				return forDrinkMaker.append("M:{" + " Missing money : " +  Math.round(moneyMissing*100.0)/100.0 + "}").toString();
			}
			
			
			switch (selectedDrink) {
			
			case OrangeJuice:
				
				forDrinkMaker.append(drinkCode + ":" + ":");
				break;
				
			default:
				
				String isExtraHotDrink = (drinkTemperature != null && !drinkTemperature.equals("")) ? Drink.extraHotDrinkCode : "";
				
				if (nbSugar == 0) {

					forDrinkMaker.append(drinkCode + isExtraHotDrink + ":" + ":");

				} else {

					forDrinkMaker.append(drinkCode + isExtraHotDrink + ":" + nbSugar + ":" +"0");
					
				}
				
				break;
			}
			
			
			return forDrinkMaker.toString();
			
		} catch (Exception e) {
			
			if (drinkCode == null) {
				return forDrinkMaker.append("M:{" + " Unknown drink code : " + choiceOfCustumer + "}").toString();
			} else {
				return forDrinkMaker.append("M:{" + " Input error : " + e.getMessage() + "}").toString();
			}
			
		}
		
	
	}

}
