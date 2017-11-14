package fr.pizzeria.model;

public class Pizza {

	private static int numberOfId = 0;
	private int id;
	private String code;
	private String nom;
	private double prix;
	
	public Pizza(String code, String nom, double prix) {
		this.id = this.numberOfId;
		this.numberOfId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	

	@Override
	public String toString() {
		return this.code + " -> " + this.nom + " ( " + this.prix + "$ )";
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
