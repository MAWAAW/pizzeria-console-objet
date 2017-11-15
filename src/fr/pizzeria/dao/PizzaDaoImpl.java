package fr.pizzeria.dao;

import java.io.*;
import java.util.*;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Mohammed BERRABAH
 *
 */
public class PizzaDaoImpl implements IPizzaDao {
		
	/**
	 * La Data Access Object est définit par une liste de pizzas
	 * On a aussi un objet pour écrire nos données dans un fichier
	 */
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	PrintWriter writer;
	
	/**
	 * Le constructeur initialise la liste avec quelques pizzas et les stockes dans un fichier
	 */
	public PizzaDaoImpl() {

		this.pizzas.add(new Pizza("PEP", "Pépéroni", 12.5,CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("MAR", "Margherita", 14,CategoriePizza.SANS_VIANDE));
		this.pizzas.add(new Pizza("REIN", "La Reine", 11.5,CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("FRO", "La 4 fromages", 12,CategoriePizza.SANS_VIANDE));
		this.pizzas.add(new Pizza("CAN", "La cannibale", 12.5,CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("SAV", "La savoyarde", 13,CategoriePizza.POISSON));
		this.pizzas.add(new Pizza("ORI", "L\'orientale", 13.5,CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("IND", "L\'indienne", 14,CategoriePizza.VIANDE));
		
		writePizza();
	}
	
	/**
	 * Ecrase le fichier pizzas.txt et écrit toutes les pizzas contenu de la liste dans le fichier
	 */
	public void writePizza() {
		try {
			writer = new PrintWriter("pizzas.txt", "UTF-8");			
			for (Pizza p: pizzas) {
				writer.println(p.toString());
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			writer.close();
		}
	}

	public List<Pizza> findAllPizzas() {
		
		return pizzas;
		
	}
	
	public boolean saveNewPizza(Pizza pizza) {
		
		if(this.pizzas.add(pizza)) {
			writePizza();
			return true;
		}
		return false;
		
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza) {	
		
		for (Pizza p: pizzas) {
			if (p.getCode().equals(codePizza)) {
				p.setCode(pizza.getCode());
				p.setNom(pizza.getNom());
				p.setPrix(pizza.getPrix());
				writePizza();
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deletePizza(String codePizza) {
		
		for (Pizza p: pizzas) {
			if (p.getCode().equals(codePizza)) {
				pizzas.remove(p);
				writePizza();
				return true;
			}
		}
		
		return false;
	}
	
}
