package fr.formation.controller;

import javax.validation.Valid;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.Classe.Joueur;
import fr.formation.DAO.IDAOJoueur;

@Controller
public class InscriptionController {
	
	@Autowired
	private IDAOJoueur daoJoueur;

	@GetMapping(value="/inscription")
	public String formulaire(Model model) {
		model.addAttribute("joueur", new Joueur());
		return "inscription";
	}
	
	@PostMapping(value="/inscription")
	public String inscription(@Valid @ModelAttribute Joueur joueur, BindingResult result, HttpSession session, Model model) {
		
		boolean pseudoExiste = false;
		if (joueur.getMotDePasse().length() < 4) {
			return "inscription";
		}
		
		for (Joueur j : daoJoueur.findAll()) {
			if (j.getPseudo().equals(joueur.getPseudo())) {
				pseudoExiste = true;
			}
		}
		if (!pseudoExiste) {
			joueur.setEstConnecte(true);
			daoJoueur.save(joueur); 
			session.setAttribute("joueurCo", joueur);
			return "redirect:/menu";
		}
		
		return "inscription";
	}
}
