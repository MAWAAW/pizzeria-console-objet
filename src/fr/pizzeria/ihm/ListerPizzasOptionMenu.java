package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;

import java.util.List;
import java.util.Scanner;

public class ListerPizzasOptionMenu extends OptionMenu {

	public ListerPizzasOptionMenu(String libelle) {
		super(libelle);
	}

	public boolean execute(IPizzaDao dao, Scanner sc) {

		List<Pizza> pizzas = dao.findAllPizzas();
		
		for (Pizza p: pizzas) {
			if (p!=null) {
				System.out.println(p);
			}
		}

		return true;

	}

}
