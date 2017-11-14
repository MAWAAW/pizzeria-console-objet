package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;
import java.util.Scanner;

public class ListerPizzasOptionMenu extends OptionMenu {

	public ListerPizzasOptionMenu(String libelle) {
		super(libelle);
	}

	public boolean execute(IPizzaDao dao, Scanner sc) {

		Pizza[] pizzas = dao.findAllPizzas();

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i]);
			}
		}

		return true;

	}

}
