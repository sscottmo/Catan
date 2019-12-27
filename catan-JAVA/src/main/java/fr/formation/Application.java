package fr.formation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.formation.Classe.Position;
import fr.formation.Classe.Type;
import fr.formation.Classe.TypePort;
import fr.formation.Classe.TypeTerre;
import fr.formation.DAO.IDAOPosition;
import fr.formation.DAO.hibernate.DAOHibernate;
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
		
		
		
//		daoPosition.findAll().forEach(p -> System.out.println(p.getId()+ " "+ p.getType()));
		
		List<TypeTerre> toRandom = new ArrayList<TypeTerre>();
		for (TypeTerre t : TypeTerre.values()) {
			for (int i = 0; i < t.getOccurences(); i++) {
				toRandom.add(TypeTerre.valueOf(t.name()));
			}
		}
		
		Collections.shuffle(toRandom);
		
		
		
		List<Position> positions = daoPosition.findAll();
		for (int i=1; i<19; i++) {
			positions.get(i)
			.setType(Type.valueOf(toRandom.remove(0).name()));
		}
		
		List<TypePort> toRandomPort = new ArrayList<TypePort>();
		for (TypePort t : TypePort.values()) {
			for (int i = 0; i < t.getOccurences(); i++) {
				toRandomPort.add(TypePort.valueOf(t.name()));
			}
		}
		
		Collections.shuffle(toRandomPort);
		
		
		
		for (int i=19; i<28; i++) {
			positions.get(i)
			.setType(Type.valueOf(toRandomPort.remove(0).name()));
		}
		
		
		for(Position p : positions) {
			daoPosition.save(p);
		}
		
//		System.out.println(daoPosition.listRand(2, 20));

//		Position position = new Position();
//		position.setType(Type.Bois);
//		
//		daoPosition.save(position);
		

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
		
	DAOHibernate.close();
	}

}
