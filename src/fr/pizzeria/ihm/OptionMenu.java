package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;
import java.util.Scanner;

public abstract class OptionMenu {
	
	private String libelle;
	
	public OptionMenu(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return this.libelle;
	}

	public abstract boolean execute(IPizzaDao dao, Scanner sc);
	
}
