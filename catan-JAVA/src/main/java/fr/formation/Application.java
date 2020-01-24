package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import fr.formation.config.AppConfig;
import fr.formation.service.PartieService;

@Component
public class Application {
	
	@Autowired
	private PartieService partieService;
		
	public void run(String[] args) {
//			

//		 while((daoUtilisateur.commencerPartie().size())<=3 & System.currentTimeMillis()-startTime<100000) {	}
//		daoJoueur.choisirJoueurs();
//		partieService.choisirJoueurs();
		partieService.creationPartie();
	}	
	
	public static void main(String[] args) {

		
		AnnotationConfigApplicationContext heySpring = new AnnotationConfigApplicationContext(AppConfig.class);
		
		heySpring.getBean(Application.class).run(args);
		
		heySpring.close();
	
	}

}
