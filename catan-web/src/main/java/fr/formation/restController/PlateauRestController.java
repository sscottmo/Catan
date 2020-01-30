package fr.formation.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.Classe.Croisement;
import fr.formation.DAO.IDAOCroisement;
import fr.formation.Views.Views;

@RestController
@RequestMapping("/api/plateau")
public class PlateauRestController {

	@Autowired
	private IDAOCroisement daoCroisement;

	private List<SseEmitter> emitters = new ArrayList<SseEmitter>();
	
	@PostMapping
	@JsonView(Views.Croisement.class)
	public Croisement save(@RequestBody Croisement croisement) {
//		System.out.println(produit.getLibelle());
		this.daoCroisement.save(croisement);
		for (SseEmitter emitter : this.emitters) {
			try {
				emitter.send(croisement);
			} 
			catch (Exception ex) {
				emitter.completeWithError(ex);
			}
		}
		return croisement;
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
