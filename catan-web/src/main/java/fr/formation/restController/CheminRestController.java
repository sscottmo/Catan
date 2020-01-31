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
import fr.formation.Classe.Chemin;
import fr.formation.Classe.Joueur;
import fr.formation.DAO.IDAOChemin;
import fr.formation.DAO.IDAOJoueur;
import fr.formation.Views.Views;

@RestController
@RequestMapping("/api/chemin")
public class CheminRestController {

	@Autowired
	private IDAOChemin daoChemin;
	
	@Autowired
	private IDAOJoueur daoJoueur;

	private List<SseEmitter> emitters = new ArrayList<SseEmitter>();
	
	@PostMapping
	@JsonView(Views.JoueurEnPartie.class)
	@Transactional
	public Chemin save(@RequestBody Chemin chem, HttpSession session) {
//		System.out.println(produit.getLibelle());
		int id = chem.getId();
		Joueur j = (Joueur) session.getAttribute("joueur");
		Joueur joueur = daoJoueur.findById(j.getId()).get();
		Chemin cheminJoueur = this.daoChemin.findById(id).get();
		cheminJoueur.setJoueur(joueur);
//		System.out.println(joueur.getBle());
		joueur.getMesChemins().add(cheminJoueur);
//		joueur.getMesChemins().forEach(c -> {
//			System.out.println(c.getId());
//			});
		daoChemin.save(cheminJoueur);
		
		
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
//		JSONObject data = new JSONObject();
//		data.addProperty("id", id);
//		data.addProperty("couleur", couleur);
		List data = new ArrayList();
		data.add(id);
		data.add(couleur);
		
		this.daoChemin.save(cheminJoueur);
		for (SseEmitter emitter : this.emitters) {
			try {
				emitter.send(data);
			} 
			catch (Exception ex) {
				ex.printStackTrace();
				emitter.completeWithError(ex);
			}
		}
		return cheminJoueur;
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
