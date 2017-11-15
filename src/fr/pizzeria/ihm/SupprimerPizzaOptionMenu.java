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
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String code = sc.nextLine();
		
		if(!dao.deletePizza(code)) {
			throw new DeletePizzaException("Impossible de supprimer cette pizza");
		}
		
		return true;
	}
	
}
