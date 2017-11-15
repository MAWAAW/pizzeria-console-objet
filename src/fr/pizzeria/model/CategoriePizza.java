package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String categorie = "";

	CategoriePizza(String categorie) {
		this.categorie = categorie;
	}
	
	public String getCategorie() {
		return this.categorie;
	}
	
	public static CategoriePizza getCategorieByIndex(int index) {
		if(index == 1) {
			return VIANDE;
		}
		else if(index == 2) {
			return POISSON;
		}
		else if(index == 3) {
			return SANS_VIANDE;
		}
		else {
			return null;
		}
	}
	
}
