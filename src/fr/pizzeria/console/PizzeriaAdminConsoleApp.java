package fr.pizzeria.console;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.*;

/**
 * @author Mohammed BERRABAH
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * Point d'entrée de l'application qui créer un menu et interragit avec l'utilisateur
	 * @param args
	 */
	public static void main(String[] args) {

		Menu m = new Menu("***** Pizzeria Administration *****");
		m.afficher();

	}

}
