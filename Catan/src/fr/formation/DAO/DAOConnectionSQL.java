package fr.formation.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import fr.formation.Classe.EntityManager;

public abstract class DAOConnectionSQL {
	protected static Connection connection = null;
	protected static EntityManager em = null;


	public void setUp() {
		try {
			if (connection == null) {
				System.out.println("connexion");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/catan?serverTimezone=UTC", "root", "silas1996");
			}
		}
		catch (Exception e) {
			System.out.println("Pb de connexion");
			e.printStackTrace();
		}
		if(em == null) {
			em = new EntityManager();
		}
	}

}
