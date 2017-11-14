package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
		
	private Pizza[] tableauPizzas = new Pizza[100];

	
	public PizzaDaoImpl() {
		this.tableauPizzas[0] = new Pizza("PEP", "Pépéroni", 12.5);
		this.tableauPizzas[1] = new Pizza("MAR", "Margherita", 14);
		this.tableauPizzas[2] = new Pizza("REIN", "La Reine", 11.5);
		this.tableauPizzas[3] = new Pizza("FRO", "La 4 fromages", 12);
		this.tableauPizzas[4] = new Pizza("CAN", "La cannibale", 12.5);
		this.tableauPizzas[5] = new Pizza("SAV", "La savoyarde", 13);
		this.tableauPizzas[6] = new Pizza("ORI", "L\'orientale", 13.5);
		this.tableauPizzas[7] = new Pizza("IND", "L\'indienne", 14);
	}

	public Pizza[] findAllPizzas() {
		
		return tableauPizzas;
		
	}
	
	public boolean saveNewPizza(Pizza pizza) {
		for (int i = 0; i < 100; i++) {

			if(tableauPizzas[i] == null) {
				this.tableauPizzas[i] = pizza;
				return true;
			}

		}
		return false;
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza) {	
		for (int i = 0; i < 100; i++) {

			if(tableauPizzas[i]!=null && tableauPizzas[i].getCode().equals(codePizza)) {
				this.tableauPizzas[i] = pizza;
				return true;
			}

		}
		
		return false;
	}
	
	public boolean deletePizza(String codePizza) {
		
		for (int i = 0; i < 100; i++) {

			if(tableauPizzas[i]!=null && tableauPizzas[i].getCode().equals(codePizza)) {
				this.tableauPizzas[i] = null;
				return true;
			}

		}
		
		return false;
	}
	
}
