package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
		
	private int taille = 100;
	private Pizza[] IPizzaDao = new Pizza[taille];

	
	public PizzaDaoImpl() {
		this.IPizzaDao[0] = new Pizza("PEP", "Pépéroni", 12.5);
		this.IPizzaDao[1] = new Pizza("MAR", "Margherita", 14);
		this.IPizzaDao[2] = new Pizza("REIN", "La Reine", 11.5);
		this.IPizzaDao[3] = new Pizza("FRO", "La 4 fromages", 12);
		this.IPizzaDao[4] = new Pizza("CAN", "La cannibale", 12.5);
		this.IPizzaDao[5] = new Pizza("SAV", "La savoyarde", 13);
		this.IPizzaDao[6] = new Pizza("ORI", "L\'orientale", 13.5);
		this.IPizzaDao[7] = new Pizza("IND", "L\'indienne", 14);
	}

	public Pizza[] findAllPizzas() {
		
		return IPizzaDao;
		
	}
	
	public boolean saveNewPizza(Pizza pizza) {
		for (int i = 0; i < taille; i++) {

			if(IPizzaDao[i] == null) {
				this.IPizzaDao[i] = pizza;
				break;
			}

		}
		return false;
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza) {	
		for (int i = 0; i < taille; i++) {

			if(IPizzaDao[i].getCode().equals(codePizza)) {
				this.IPizzaDao[i] = pizza;
				break;
			}

		}
		
		return false;
	}
	
	public boolean deletePizza(String codePizza) {
		
		for (int i = 0; i < taille; i++) {

			if(IPizzaDao[i].getCode().equals(codePizza)) {
				this.IPizzaDao[i] = null;
				break;
			}

		}
		
		return false;
	}
	
}
