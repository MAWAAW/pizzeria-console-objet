package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.*;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Pizzaria p = new Pizzaria();
		
		int choix = 0;
	
		while (choix != 99) {
			
			p.menu();

			choix = Integer.parseInt(sc.nextLine());

			switch (choix) {

			case 1:
				p.affichePizzas();
				break;
			case 2:
				System.out.println("Veuillez saisir le code");
				String code = sc.nextLine();
				System.out.println("Veuillez saisir le nom (sans espace)");
				String nom = sc.nextLine();
				System.out.println("Veuillez saisir le prix");
				double prix = Double.parseDouble(sc.nextLine());
				p.ajoutePizza(code, nom, prix);
				break;
			case 3:
				p.affichePizzas();
				System.out.println("Veuillez saisir le code de la pizza à modifier");
				Pizza pizzaAModifier = p.cherchePizza(sc.nextLine());
				if (pizzaAModifier != null) {
					System.out.println("Veuillez saisir le code");
					String code2 = sc.nextLine();
					System.out.println("Veuillez saisir le nom (sans espace)");
					String nom2 = sc.nextLine();
					System.out.println("Veuillez saisir le prix");
					double prix2 = Double.parseDouble(sc.nextLine());
					p.modifPizza(pizzaAModifier, code2, nom2, prix2);
				}
				else {
					System.out.println("La pizza n\'existe pas...");
				}
				break;
			case 4:
				p.affichePizzas();
				System.out.println("Veuillez saisir le code de la pizza à supprimer");
				Pizza pizzaASupprimer = p.cherchePizza(sc.nextLine());
				if (pizzaASupprimer != null) {
					p.supprimePizza(pizzaASupprimer);
				}
				else {
					System.out.println("La pizza n\'existe pas...");
				}
				break;
			case 99:
				choix = 99;
				break;
			default:
				System.out.println("Choix invalide...");
				break;
			}

		}
		
		System.out.println("fin du programme...");
		
		sc.close();
	}

}
