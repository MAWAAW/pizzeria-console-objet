package fr.pizzeria.model;

/**
 * @author Mohammed BERRABAH
 *
 */
public class Pizza {

	
	/**
	 * Une pizza est définit par son id, son code, son nom, son prix et sa catégorie
	 */
	private static int numberOfId = 0;
	private int id;
	@ToString(uppercase = true)
	private String code;
	private String nom;
	@ToString
	private double prix;
	private CategoriePizza categorie;
	
	/**
	 * Pizza permet de construire une pizza à partir d'un code pizza, d'un nom, d'un prix et d'une catégorie
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.id = numberOfId;
		numberOfId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	

	@Override
	public String toString() {
		return "Pizza id "+ this.id+ ": "+this.code + " -> " + this.nom + " ( " + this.prix + "$ ) categorie("+this.categorie+")" ;
	}


	public int getId() {
		
		return this.id;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}
	
	public String getCode() {
		
		return this.code;
	}
	
	public void setCode(String code) {
		
		this.code = code;
	}
	
	public String getNom() {
		
		return this.nom;
	}
	
	public void setNom(String nom) {
		
		this.nom = nom;
	}
	
	public double getPrix() {
		
		return this.prix;
	}
	
	public void setPrix(double prix) {
		
		this.prix = prix;
	}
}
