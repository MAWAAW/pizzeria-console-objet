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
	 * @return true si la pizza a été rajouter avec succès, false sinon
	 */
	boolean saveNewPizza(Pizza pizza);
	
	/**
	 * @param codePizza
	 * @param pizza
	 * @return true si la pizza a été modifier avec succès, false sinon
	 */
	boolean updatePizza(String codePizza, Pizza pizza);
	
	/**
	 * @param codePizza
	 * @return true si la pizza a été supprimer avec succès, false sinon
	 */
	boolean deletePizza(String codePizza);
	
}
