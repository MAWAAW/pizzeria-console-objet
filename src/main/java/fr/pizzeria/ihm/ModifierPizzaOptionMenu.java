package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.*;
import java.util.Scanner;

public class ModifierPizzaOptionMenu extends OptionMenu {

	public ModifierPizzaOptionMenu(String libelle) {
		super(libelle);
	}

	public boolean execute(IPizzaDao dao, Scanner sc) throws UpdatePizzaException {
		
		System.out.println("Veuillez saisir le code de la pizza à modifier");
		String code = sc.nextLine();
		
		System.out.println("Veuillez saisir le code");
		String nouveauCode = sc.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		double prix = Double.parseDouble(sc.nextLine());
		
		System.out.println("Veuillez saisir la catégorie (1.Viande, 2.Poisson, 3.Sans Viande)");
		int categorie = Integer.parseInt(sc.nextLine());
		
		Pizza pizza = new Pizza(nouveauCode, nom, prix, CategoriePizza.getCategorieByIndex(categorie));
		
		if(!dao.updatePizza(code, pizza)) {
			throw new UpdatePizzaException("Impossible de modifier cette pizza");
		}
		
		return true;
	}
	
}
