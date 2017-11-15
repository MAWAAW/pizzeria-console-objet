package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	/**
	 * @return la liste de toutes les pizzas
	 */
	List<Pizza> findAllPizzas();
	
	/**
	 * @param pizza
	 * @return true si la pizza a �t� rajouter avec succ�s, false sinon
	 */
	boolean saveNewPizza(Pizza pizza);
	
	/**
	 * @param codePizza
	 * @param pizza
	 * @return true si la pizza a �t� modifier avec succ�s, false sinon
	 */
	boolean updatePizza(String codePizza, Pizza pizza);
	
	/**
	 * @param codePizza
	 * @return true si la pizza a �t� supprimer avec succ�s, false sinon
	 */
	boolean deletePizza(String codePizza);
	
}
