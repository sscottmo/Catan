package fr.formation.restController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
import fr.formation.Classe.Position;
import fr.formation.Classe.Type;
import fr.formation.DAO.IDAOCroisement;
import fr.formation.DAO.IDAOJoueur;
import fr.formation.DAO.IDAOPosition;
import fr.formation.Views.Views;

@RestController
@RequestMapping("/api/plateau")
public class PlateauRestController {
	
	@Autowired
	private IDAOPosition daoPosition;

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
//		JSONObject data = new JSONObject();
//		data.addProperty("id", id);
//		data.addProperty("couleur", couleur);
		List data = new ArrayList();
		data.add(id);
		data.add(couleur);
		
		this.daoCroisement.save(croisementJoueur);
		for (SseEmitter emitter : this.emitters) {
			try {
				emitter.send(data);
			} 
			catch (Exception ex) {
				ex.printStackTrace();
				emitter.completeWithError(ex);
			}
		}
		return croisementJoueur;
	}

	@PostMapping("/de")
	@JsonView(Views.AjoutRessource.class)
	@Transactional
	public void ajouteRes(@RequestBody Joueur resDe, Model model) {
		int de = resDe.getId();
		for(Position p : daoPosition.findAll()) {
			if(p.getVal() == de) {
				for(Croisement c : p.getLesCroisements()) {
					if(c.getJoueur() != null) {
						Type type = p.getType();
						if(type == Type.Argile) {
							c.getJoueur().setArgile(c.getJoueur().getArgile()+1);
						}
						if(type == Type.Bois) {
							c.getJoueur().setBois(c.getJoueur().getBois()+1);
						}
						if(type == Type.Laine) {
							c.getJoueur().setLaine(c.getJoueur().getLaine()+1);
						}
						if(type == Type.Ble) {
							c.getJoueur().setBle(c.getJoueur().getBle()+1);
						}
						if(type == Type.Minerai) {
							c.getJoueur().setMinerai(c.getJoueur().getMinerai()+1);
						}
					}
				}
			}
		}
	}

	@GetMapping("/sse")
	public SseEmitter Sse() {
		SseEmitter emitter = new SseEmitter();
		// Actions � faire quand l'event est compl�t�
		emitter.onCompletion(() -> {
			// Permet d'�tre sur qu'on est seul � utiliser la liste
			synchronized (this.emitters) {
				this.emitters.remove(emitter);

			}
		});
		// Actions � faire quand l'event est en timeout
		emitter.onTimeout(() -> {
			emitter.complete();

		});
		emitters.add(emitter);
		return emitter;
	}
}
