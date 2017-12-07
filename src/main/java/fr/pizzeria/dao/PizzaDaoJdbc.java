package fr.pizzeria.dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.management.RuntimeErrorException;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Mohammed BERRABAH
 *
 */

public class PizzaDaoJdbc implements IPizzaDao {
	
	/**
	 * La Data Access Object est définit par une liste de pizzas
	 * On a aussi un objet pour écrire nos données dans un fichier
	 */
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	Connection conn = null;
	PreparedStatement stat = null;
	ResourceBundle bundle = null;
	
	/**
	 * Le constructeur ouvre une connection puis initialise la liste avec quelques pizzas et les stockes dans la base
	 */
	public PizzaDaoJdbc() {
		
		try {
			bundle = ResourceBundle.getBundle("jdbc");
			Class.forName(bundle.getString("driver"));
			System.out.println("Connecting to database...");
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage()+" Impossible de trouver le .properties ou le driver...");
		}

		/*saveNewPizza(new Pizza("PEP", "Peperoni", 12.5, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("MAR", "Margherita", 14, CategoriePizza.SANS_VIANDE));
		saveNewPizza(new Pizza("REIN", "La Reine", 11.5, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("FRO", "La 4 fromages", 12, CategoriePizza.SANS_VIANDE));
		saveNewPizza(new Pizza("CAN", "La cannibale", 12.5, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("SAV", "La savoyarde", 13, CategoriePizza.POISSON));
		saveNewPizza(new Pizza("ORI", "L'orientale", 13.5, CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("IND", "L'indienne", 14, CategoriePizza.VIANDE));*/
		
	}
	
	public List<Pizza> findAllPizzas() {
		try {
			conn = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("password"));
			System.out.println("Creating statement READ...");
			stat = conn.prepareStatement("SELECT * FROM pizza");
			ResultSet res = stat.executeQuery();
			while(res.next()) {
				int id = res.getInt("id");
				String code = res.getString("code");
				String nom = res.getString("nom");
				Double prix = res.getDouble("prix");
				CategoriePizza categorie = CategoriePizza.valueOf(res.getString("categorie"));
				Pizza p = new Pizza(id, code, nom, prix, categorie);
				pizzas.add(p);
			}
			stat.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
					se.printStackTrace();
			}
		}
		return pizzas;
	}
	
	public boolean saveNewPizza(Pizza pizza) {
		
		try {
			conn = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("password"));
			System.out.println("Creating statement CREATE...");
			stat = conn.prepareStatement("INSERT INTO pizza (code, nom, prix, categorie) VALUES(?,?,?,?)");
			stat.setString(1, pizza.getCode());
			stat.setString(2, pizza.getNom());
			stat.setDouble(3, pizza.getPrix());
			stat.setString(4, pizza.getCategorie().name());
			stat.executeUpdate();
			stat.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
					se.printStackTrace();
			}finally{
					return true;
			}
		}
		
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza) {	
		try {
			conn = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("password"));
			System.out.println("Creating statement UPDATE...");
			stat = conn.prepareStatement("UPDATE pizza SET code=?, nom=?, prix=?, categorie=? WHERE code=?");
			stat.setString(1, pizza.getCode());
			stat.setString(2, pizza.getNom());
			stat.setDouble(3, pizza.getPrix());
			stat.setString(4, pizza.getCategorie().name());
			stat.setString(5, codePizza);
			stat.executeUpdate();
			stat.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
					se.printStackTrace();
			}finally{
					return true;
			}
		}
	}
	
	public boolean deletePizza(String codePizza) {
		try {
			conn = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("password"));
			System.out.println("Creating statement DELETE...");
			stat = conn.prepareStatement("DELETE FROM pizza WHERE code=?");
			stat.setString(1, codePizza);
			stat.executeUpdate();
			stat.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
					se.printStackTrace();
			}finally{
					return true;
			}
		}
	}

}
