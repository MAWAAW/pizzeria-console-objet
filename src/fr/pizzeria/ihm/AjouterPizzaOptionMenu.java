package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.*;
import java.util.Scanner;

public class AjouterPizzaOptionMenu extends OptionMenu {

	public AjouterPizzaOptionMenu(String libelle) {
		super(libelle);
	}

	public boolean execute(IPizzaDao dao, Scanner sc) throws SavePizzaException {
		
		/*Pizza[] pizzas = dao.findAllPizzas();
		
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i]);
			}
		}*/
		
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		double prix = Double.parseDouble(sc.nextLine());
		
		Pizza pizza = new Pizza(code, nom, prix);
		
		if(!dao.saveNewPizza(pizza)) {
			throw new SavePizzaException("Impossible d\'ajouter cette pizza");
		}
		
		return true;
	}
	
}
