package fr.formation;

import java.util.Scanner;

import fr.formation.DAO.IDAOCroisement;
import fr.formation.DAO.IDAOPosition;
import fr.formation.DAO.hibernate.DAOCroisementHibernate;
import fr.formation.DAO.hibernate.DAOHibernate;
import fr.formation.DAO.hibernate.DAOPositionHibernate;

public class Application {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		IDAOPosition daoPosition = new DAOPositionHibernate();
		IDAOCroisement daoCroisement = new DAOCroisementHibernate();

		daoPosition.attributionDesTypes();
		daoCroisement.definitionDesPorts();

		DAOHibernate.close();
	}

}
