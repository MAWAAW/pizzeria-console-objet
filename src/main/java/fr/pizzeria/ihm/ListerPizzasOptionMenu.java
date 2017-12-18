package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;

import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class ListerPizzasOptionMenu extends OptionMenu {

	public ListerPizzasOptionMenu(String libelle) {
		super(libelle);
	}

	public boolean execute(IPizzaDao dao, Scanner sc) {

		dao.findAllPizzas().stream().forEach(p -> System.out.println(p));
	
		return true;

	}

}
