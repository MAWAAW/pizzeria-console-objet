package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.*;
import java.util.Scanner;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	public SupprimerPizzaOptionMenu(String libelle) {
		super(libelle);
	}

	public boolean execute(IPizzaDao dao, Scanner sc) throws DeletePizzaException {
		
		/*Pizza[] pizzas = dao.findAllPizzas();
		
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i]);
			}
		}*/
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String code = sc.nextLine();
		
		if(!dao.deletePizza(code)) {
			throw new DeletePizzaException("Impossible de supprimer cette pizza");
		}
		
		return true;
	}
	
}
