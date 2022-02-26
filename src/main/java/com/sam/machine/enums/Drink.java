package com.sam.machine.enums;

public enum Drink {

	Coffee("C"){
		@Override
		public Double getPrice() {
			return 0.6;
		}
	},
	
	Tea("T"){
		@Override
		public Double getPrice() {
			return 0.4;
		}
	},
	
	Chocolate("H"){
		@Override
		public Double getPrice() {
			return 0.5;
		}
	},
	
	OrangeJuice("O"){
		@Override
		public Double getPrice() {
			return 0.6;
		}
	};
	
	Drink(String drinkCode) {
		this.drinkCode = drinkCode;
	}
	
	private String drinkCode;
	
	public String getDrinkCode() {
		return drinkCode;
	}

	public abstract Double getPrice();
	
	public static final String extraHotDrinkCode = "h";

}
