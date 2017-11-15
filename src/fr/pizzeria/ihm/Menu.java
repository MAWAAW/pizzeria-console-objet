package fr.pizzeria.ihm;

import java.util.*;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;

import java.util.Scanner;

public class Menu {

	private String titre;
	
	private Map<Integer, OptionMenu> actions = new HashMap<Integer, OptionMenu>();
	
	public Menu(String titre) {
		this.titre = titre;
		
		this.actions.put(1, new ListerPizzasOptionMenu("Lister les pizzas"));
		this.actions.put(2, new AjouterPizzaOptionMenu("Ajouter une nouvelle pizza"));
		this.actions.put(3, new ModifierPizzaOptionMenu("Mettre à jour une pizza"));
		this.actions.put(4, new SupprimerPizzaOptionMenu("Supprimer une pizza"));
		
	}

	public void afficher() {

		Scanner sc = new Scanner(System.in);

		IPizzaDao dao = new PizzaDaoImpl();

		int choix = 0;

		while (choix != 99) {

			System.out.println(titre);
			for (Map.Entry m: actions.entrySet()) {
				System.out.println(m.getKey()+". "+m.getValue());
			}
			System.out.println("99. Sortir");

			choix = Integer.parseInt(sc.nextLine());

			try {
				
				if(choix == 99) {
					System.out.println("Au revoir...");
					System.exit(0);
				}
				
				actions.get(choix).execute(dao, sc);		
				
			}
			
			catch(StockageException e) {
				
				System.out.println(e.getMessage());
				
			}

		}

	}

}
