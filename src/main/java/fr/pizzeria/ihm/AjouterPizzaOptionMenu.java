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
		
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = sc.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		double prix = Double.parseDouble(sc.nextLine());
		
		System.out.println("Veuillez saisir la catégorie (1.Viande, 2.Poisson, 3.Sans Viande)");
		int categorie = Integer.parseInt(sc.nextLine());
		
		Pizza pizza = new Pizza(code, nom, prix, CategoriePizza.getCategorieByIndex(categorie));
		
		if(!dao.saveNewPizza(pizza)) {
			throw new SavePizzaException("Impossible d\'ajouter cette pizza");
		}
		
		return true;
	}
	
}
