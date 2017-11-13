package fr.pizzeria.model;

import java.util.Scanner;

public class Pizzaria {

	private int taille = 100;
	Pizza[] tableauPizzas = new Pizza[taille];

	public Pizzaria() {
		this.tableauPizzas[0] = new Pizza("PEP", "Pépéroni", 12.5);
		this.tableauPizzas[1] = new Pizza("MAR", "Margherita", 14);
		this.tableauPizzas[2] = new Pizza("REIN", "La Reine", 11.5);
		this.tableauPizzas[3] = new Pizza("FRO", "La 4 fromages", 12);
		this.tableauPizzas[4] = new Pizza("CAN", "La cannibale", 12.5);
		this.tableauPizzas[5] = new Pizza("SAV", "La savoyarde", 13);
		this.tableauPizzas[6] = new Pizza("ORI", "L\'orientale", 13.5);
		this.tableauPizzas[7] = new Pizza("IND", "L\'indienne", 14);
	}

	public void menu() {

		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");

	}

	public void affichePizzas() {

		for (int i = 0; i < taille; i++) {
			
			if(tableauPizzas[i]!=null) {
				System.out.println(tableauPizzas[i].getCode() + " -> " + tableauPizzas[i].getNom() + " (" + tableauPizzas[i].getPrix() + "$)");
			}

		}

	}

	public void ajoutePizza(String code, String nom, double prix) {

		for (int i = 0; i < taille; i++) {

			if(tableauPizzas[i] == null) {
				this.tableauPizzas[i] = new Pizza(code, nom, prix);
				break;
			}

		}

	}

	public Pizza cherchePizza(String code) {
		
		for (int i = 0; i < taille; i++) {
			
			if(tableauPizzas[i] == null) {
				break;
			}
			
			if(tableauPizzas[i].getCode().equals(code)) {
				
				return tableauPizzas[i];
			}

		}
		return null;

	}

	public void modifPizza(Pizza pizzaAModifier, String code, String nom, double prix) {

		for (int i = 0; i < taille; i++) {

			if(tableauPizzas[i] == null) {
				break;
			}
			
			if(tableauPizzas[i].equals(pizzaAModifier)) {
				tableauPizzas[i].setCode(code);
				tableauPizzas[i].setNom(nom);
				tableauPizzas[i].setPrix(prix);
			}

		}

	}
	
	public void supprimePizza(Pizza pizzaASupprimer) {

		
		for (int i = 0; i < taille; i++) {

			if(tableauPizzas[i] == null) {
				break;
			}
			
			if(tableauPizzas[i].equals(pizzaASupprimer)) {
				tableauPizzas[i] = null;
				break;
			}

		}
		
	}

}
