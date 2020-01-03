package fr.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import fr.formation.Classe.Partie;
import fr.formation.Classe.Position;
import fr.formation.DAO.IDAOCarte;
import fr.formation.DAO.IDAOCroisement;
import fr.formation.DAO.IDAOJoueur;
import fr.formation.DAO.IDAOPartie;
import fr.formation.DAO.IDAOPosition;
import fr.formation.DAO.IDAOUtilisateur;
import fr.formation.config.AppConfig;

@Component
public class Application {

	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	@Autowired
	private IDAOJoueur daoJoueur;
	@Autowired
	private IDAOPosition daoPosition;
	@Autowired
	private IDAOCroisement daoCroisement;
	@Autowired
	private IDAOCarte daoCarte;
	@Autowired
	private IDAOPartie daoPartie;
		
		public void run(String[] args) {
//			

//			 while((daoUtilisateur.commencerPartie().size())<=3 & System.currentTimeMillis()-startTime<100000) {	}
//			daoJoueur.choisirJoueurs();
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
//				pos.setChemins1(p.getChemins1());
//				pos.setChemins2(p.getChemins2());
//				pos.setCroisements1(p.getCroisements1());
//				pos.setCroisements2(p.getCroisements2());
//				pos.setCroisements3(p.getCroisements3());

				positionsPartie.add(pos);
				
			});
			
//			for (Position p : maPartie.getTerrain()) {
//				p.setPartie(partie);
//			}
			
			maPartie.setTerrain(positionsPartie);
			maPartie.setJoueurs(daoJoueur.affecterJoueurs());
			daoPartie.save(maPartie);
//			positionsPartie.forEach(p->daoPosition.save(p));
			
//					 joueurs.forEach(j-> {
//				 System.out.println(j.getNom()+" "+j.getCouleur()+" "+j.getLaine());
//			 });
		}	
	
	public static void main(String[] args) {

		
		AnnotationConfigApplicationContext heySpring = new AnnotationConfigApplicationContext(AppConfig.class);
		
		heySpring.getBean(Application.class).run(args);
		
		heySpring.close();
	
	}

}
