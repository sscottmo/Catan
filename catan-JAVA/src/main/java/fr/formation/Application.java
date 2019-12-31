package fr.formation;

import java.util.List;
import java.util.Scanner;

import fr.formation.Classe.Partie;
import fr.formation.Classe.Position;
import fr.formation.DAO.IDAOCarte;
import fr.formation.DAO.IDAOCroisement;
import fr.formation.DAO.IDAOJoueur;
import fr.formation.DAO.IDAOPartie;
import fr.formation.DAO.IDAOPosition;
import fr.formation.DAO.IDAOUtilisateur;
import fr.formation.DAO.hibernate.DAOCarteHibernate;
import fr.formation.DAO.hibernate.DAOCroisementHibernate;
import fr.formation.DAO.hibernate.DAOHibernate;
import fr.formation.DAO.hibernate.DAOJoueurHibernate;
import fr.formation.DAO.hibernate.DAOPartieHibernate;
import fr.formation.DAO.hibernate.DAOPositionHibernate;
import fr.formation.DAO.hibernate.DAOUtilisateurHibernate;
import fr.formation.DAO.sql.DAOCarte;

public class Application {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		IDAOUtilisateur daoUtilisateur = new DAOUtilisateurHibernate();
		IDAOJoueur daoJoueur = new DAOJoueurHibernate();

		IDAOPosition daoPosition = new DAOPositionHibernate();
		IDAOCroisement daoCroisement = new DAOCroisementHibernate();
		IDAOCarte daoCarte = new DAOCarteHibernate();
		IDAOPartie daoPartie = new DAOPartieHibernate();

//		 while((daoUtilisateur.commencerPartie().size())<=3 & System.currentTimeMillis()-startTime<100000) {	}
//		daoJoueur.choisirJoueurs();
		daoPosition.attributionDesTypes();
		daoCroisement.definitionDesPorts();
		Partie maPartie = new Partie();
		maPartie.setPioche(daoCarte.melangePioche());
		List<Position> positions = daoPosition.findAll();
		positions.forEach(p -> {
			if (p.getId() > 37) {
				positions.remove(p);
			}
		});
		List<Position> positionsPartie = daoPosition.findAll();

		positions.forEach(p -> {
			Position pos = new Position();
			pos.setType(p.getType());
			pos.setVal(p.getVal());
//			pos.setChemins1(p.getChemins1());
//			pos.setChemins2(p.getChemins2());
//			pos.setCroisements1(p.getCroisements1());
//			pos.setCroisements2(p.getCroisements2());
//			pos.setCroisements3(p.getCroisements3());

			positionsPartie.add(pos);
			
		});
		
//		for (Position p : maPartie.getTerrain()) {
//			p.setPartie(partie);
//		}
		
		maPartie.setTerrain(positionsPartie);
		maPartie.setJoueurs(daoJoueur.affecterJoueurs());
		daoPartie.save(maPartie);
//		positionsPartie.forEach(p->daoPosition.save(p));
		
//				 joueurs.forEach(j-> {
//			 System.out.println(j.getNom()+" "+j.getCouleur()+" "+j.getLaine());
//		 });

		DAOHibernate.close();
	}

}
