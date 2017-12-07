package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	/**
	 * @return la liste de toutes les pizzas
	 */
	List<Pizza> findAllPizzas();
	
	/**
	 * @param pizza
	 * @return true si la pizza a été rajouter avec succés, false sinon
	 */
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	
	/**
	 * @param codePizza
	 * @param pizza
	 * @return true si la pizza a été modifier avec succés, false sinon
	 */
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	
	/**
	 * @param codePizza
	 * @return true si la pizza a été supprimer avec succés, false sinon
	 */
	boolean deletePizza(String codePizza) throws DeletePizzaException;
	
}
