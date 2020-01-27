package fr.formation.controller;

import javax.validation.Valid;

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

	@GetMapping(value="/accueil")
	public String formulaire(Model model) {
		model.addAttribute("joueur", new Joueur());
		return "accueil";
	}
	
	@PostMapping(value="/accueil")
	public String ajoutProduit(@Valid @ModelAttribute Joueur joueur, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "accueil";
		}
		
		daoJoueur.save(joueur);
		
		return "redirect:/menu";
		
	}
}
