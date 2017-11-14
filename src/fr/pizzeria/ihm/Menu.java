package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;

import java.util.Scanner;

public class Menu {

	private String titre;
	private OptionMenu[] actions = new OptionMenu[100];

	public Menu(String titre) {
		this.titre = titre;
		this.actions[1] = new ListerPizzasOptionMenu("1. Lister les pizzas");
		this.actions[2] = new AjouterPizzaOptionMenu("2. Ajouter une nouvelle pizza");
		this.actions[3] = new ModifierPizzaOptionMenu("3. Mettre à jour une pizza");
		this.actions[4] = new SupprimerPizzaOptionMenu("4. Supprimer une pizza");
	}

	public void afficher() {

		Scanner sc = new Scanner(System.in);

		IPizzaDao dao = new PizzaDaoImpl();

		int choix = 0;

		while (choix != 99) {

			System.out.println(titre);
			for (int i = 0; i < 100; i++) {
				if (actions[i] != null) {
					System.out.println(actions[i]);
				}
			}
			System.out.println("99. Sortir");

			choix = Integer.parseInt(sc.nextLine());

			try {
			
				switch (choix) {
	
				case 1:
					actions[1].execute(dao, sc);
					break;
				case 2:
					actions[2].execute(dao, sc);
					break;
				case 3:
					actions[3].execute(dao, sc);
					break;
				case 4:
					actions[4].execute(dao, sc);
					break;
				case 99:
					choix = 99;
					break;
				default:
					System.out.println("Choix invalide...");
					break;
				}
			}
			
			catch(StockageException e) {
				
				System.out.println(e.getMessage());
				
			}

		}

	}

}
