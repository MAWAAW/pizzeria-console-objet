package fr.pizzeria.console;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.*;

/**
 * @author Mohammed BERRABAH
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * Point d'entr�e de l'application qui creer un menu et interragit avec l'utilisateur
	 * @param args
	 */
	public static void main(String[] args) {

		Menu m = new Menu("***** Pizzeria Administration *****");
		m.afficher();

	}

}
