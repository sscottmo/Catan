package fr.formation;

import java.util.Scanner;

import fr.formation.Classe.Carte;
import fr.formation.Classe.CarteDev;
import fr.formation.Classe.Partie;
import fr.formation.Classe.Position;
import fr.formation.Classe.Type;
import fr.formation.Classe.TypePort;
import fr.formation.Classe.TypeTerre;
import fr.formation.DAO.IDAOCarte;
import fr.formation.DAO.IDAOPartie;
import fr.formation.DAO.IDAOCroisement;
import fr.formation.DAO.IDAOPosition;
import fr.formation.DAO.IDAOUtilisateur;
import fr.formation.DAO.hibernate.DAOCarteHibernate;
import fr.formation.DAO.hibernate.DAOCroisementHibernate;
import fr.formation.DAO.hibernate.DAOHibernate;
import fr.formation.DAO.hibernate.DAOPartieHibernate;
import fr.formation.DAO.hibernate.DAOPositionHibernate;
import fr.formation.DAO.hibernate.DAOUtilisateurHibernate;

public class Application {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurHibernate();
		while((daoUtilisateur.commencerPartie().size())<=3 & System.currentTimeMillis()-startTime<100000) {	}
		daoUtilisateur.choisirJoueur();	
		IDAOPosition daoPosition = new DAOPositionHibernate();
		IDAOCroisement daoCroisement = new DAOCroisementHibernate();

		daoPosition.attributionDesTypes();
		daoCroisement.definitionDesPorts();

		DAOHibernate.close();
	}

}
