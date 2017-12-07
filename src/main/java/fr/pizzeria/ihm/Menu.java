package fr.pizzeria.ihm;

import java.util.*;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;

import java.util.Scanner;

/**
 * @author Mohammed BERRABAH
 *
 */
public class Menu {

	/**
	 * Le Menu est composé d'un titre et d'une liste d'actions possibles
	 */
	private String titre;
	private Map<Integer, OptionMenu> actions = new HashMap<Integer, OptionMenu>();
	
	/**
	 * Le Menu permet les actions CRUD sur des pizzas
	 * @param titre
	 */
	public Menu(String titre) {
		this.titre = titre;
		this.actions.put(1, new ListerPizzasOptionMenu("Lister les pizzas"));
		this.actions.put(2, new AjouterPizzaOptionMenu("Ajouter une nouvelle pizza"));
		this.actions.put(3, new ModifierPizzaOptionMenu("Mettre � jour une pizza"));
		this.actions.put(4, new SupprimerPizzaOptionMenu("Supprimer une pizza"));
		
	}

	/**
	 * Affichage en boucle du Menu jusqu'a ce que l'utilisateur quitte le programme
	 */
	public void afficher() {

		Scanner sc = new Scanner(System.in);

		//IPizzaDao dao = new PizzaDaoImpl();
		IPizzaDao dao = new PizzaDaoJdbc();

		int choix = 0;
		while (choix != 99) {

			System.out.println(titre);
			for (Map.Entry m: actions.entrySet()) {
				System.out.println(m.getKey()+". "+m.getValue());
			}
			System.out.println("99. Sortir");

			try {
				choix = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e) {
				System.out.println("Les choix valides sont 1, 2, 3, 4 et 99");
				continue;
			}

			if(choix == 99) {
				System.out.println("Au revoir...");
				System.exit(0);
			}
			
			if(actions.containsKey(choix)) {
				try {
					actions.get(choix).execute(dao, sc);					
				}
				catch(StockageException e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("Ce choix n\'est pas valide...");
				continue;
			}
		}

	}

}
