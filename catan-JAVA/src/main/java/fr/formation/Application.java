package fr.formation;

import java.util.Scanner;

import fr.formation.Classe.Position;
import fr.formation.DAO.IDAOPosition;
import fr.formation.DAO.hibernate.DAOPositionHibernate;

public class Application {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Connection connection = null;

//		try {
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/catan?serverTimezone=UTC", "root", "maxxxou1994");
//			System.out.println("Connexion reussie");
//		}
//		catch (Exception e) {
//			System.out.println("Echec de la connexion");
//			e.printStackTrace();
//		}

		
		
		IDAOPosition daoPosition = new DAOPositionHibernate();
		
//		Position position = new Position();
//		position.setType(Type.Bois);
//		
//		daoPosition.save(position);
		
//		for (Position p : daoPosition.findAll()) {
//			System.out.println(p.getId() +" "+ p.getPos() +" "+ p.getVal() +" "+ p.getType());
//		}
//		
//
//		System.out.println("Id de la carte à supprimer dans la liste : ");
//		int id = sc.nextInt();
//
//		daoPosition.deleteById(id);
//
//		for (Position p : daoPosition.findAll()) {
//			System.out.println(p.getId() +" "+ p.getPos() +" "+ p.getVal() +" "+ p.getType());
//		}
	}

}
