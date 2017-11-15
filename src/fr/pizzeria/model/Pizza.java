package fr.pizzeria.model;

public class Pizza {

	private static int numberOfId = 0;
	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie;
	
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
