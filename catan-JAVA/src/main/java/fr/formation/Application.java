package fr.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import fr.formation.Classe.Position;
import fr.formation.DAO.IDAOPosition;
import fr.formation.config.AppConfig;
import fr.formation.service.PartieService;

@Component
public class Application {
	@Autowired
	private IDAOPosition daoPosition;
	
	@Autowired
	private PartieService partieService;
		
	public void run(String[] args) {
//			

//		 while((daoUtilisateur.commencerPartie().size())<=3 & System.currentTimeMillis()-startTime<100000) {	}
//		daoJoueur.choisirJoueurs();
//		partieService.choisirJoueurs();
//		partieService.creationPartie();
		 List<Position> positions= daoPosition.orderByPositions();
		 positions.forEach(p -> System.out.println(p.getId() + " " + p.getX() +" "+ p.getY()));
	}	
	
	public static void main(String[] args) {

		
		AnnotationConfigApplicationContext heySpring = new AnnotationConfigApplicationContext(AppConfig.class);
		
		heySpring.getBean(Application.class).run(args);
		
		heySpring.close();
	
	}

}
