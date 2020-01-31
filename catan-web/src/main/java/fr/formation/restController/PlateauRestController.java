package fr.formation.restController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.Classe.Couleur;
import fr.formation.Classe.Croisement;
import fr.formation.Classe.Joueur;
import fr.formation.DAO.IDAOCroisement;
import fr.formation.DAO.IDAOJoueur;
import fr.formation.Views.Views;

@RestController
@RequestMapping("/api/plateau")
public class PlateauRestController {

	@Autowired
	private IDAOCroisement daoCroisement;
	
	@Autowired
	private IDAOJoueur daoJoueur;

	private List<SseEmitter> emitters = new ArrayList<SseEmitter>();
	
	@PostMapping
	@JsonView(Views.JoueurEnPartie.class)
	@Transactional
	public Croisement save(@RequestBody Croisement crois, HttpSession session) {
//		System.out.println(produit.getLibelle());
		int id = crois.getId();
		Joueur j = (Joueur) session.getAttribute("joueur");
		Joueur joueur = daoJoueur.findById(j.getId()).get();
		Croisement croisementJoueur = this.daoCroisement.findById(id);
		croisementJoueur.setJoueur(joueur);
//		System.out.println(joueur.getBle());
		joueur.getMesCroisements().add(croisementJoueur);
//		joueur.getMesCroisements().forEach(c -> {
//			System.out.println(c.getId());
//			});
		daoCroisement.save(croisementJoueur);
		
		
		Couleur couleurJoueur = joueur.getCouleur();
		String couleur = null;
		if (couleurJoueur == Couleur.Cyan) {
			couleur = "cyan";
		}
		else if (couleurJoueur == Couleur.Violet) {
			couleur = "purple";
		}
		else if (couleurJoueur == Couleur.Marron) {
			couleur = "brown";
		}
		else {
			couleur ="orange";
		}
		
		List data = new ArrayList();
		data.add(id);
		data.add(couleur);
		this.daoCroisement.save(croisementJoueur);
		for (SseEmitter emitter : this.emitters) {
			try {
				emitter.send(data);
			} 
			catch (Exception ex) {
				emitter.completeWithError(ex);
			}
		}
		return croisementJoueur;
	}



	@GetMapping("/sse")
	public SseEmitter Sse() {
		SseEmitter emitter = new SseEmitter();
		// Actions à faire quand l'event est complété
		emitter.onCompletion(() -> {
			// Permet d'être sur qu'on est seul à utiliser la liste
			synchronized (this.emitters) {
				this.emitters.remove(emitter);

			}
		});
		// Actions à faire quand l'event est en timeout
		emitter.onTimeout(() -> {
			emitter.complete();

		});
		emitters.add(emitter);
		return emitter;
	}
}
