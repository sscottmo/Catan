package fr.formation.controller;

import javax.servlet.http.HttpSession;
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
public class ConnexionController {

	@Autowired
	private IDAOJoueur daoJoueur;

	@GetMapping(value="/connexion")
	public String formulaire(Model model) {
		model.addAttribute("joueur", new Joueur());
		return "connexion";
	}
	
	@PostMapping(value="/connexion")
	public String connexion(@Valid @ModelAttribute Joueur joueur, BindingResult result, HttpSession session, Model model) {
		
		for (Joueur j : daoJoueur.findAll()) {
			if (j.getPseudo().equals(joueur.getPseudo())) {
				if (j.getMotDePasse().contentEquals(joueur.getMotDePasse())) {
					j.setEstConnecte(true);
					session.setAttribute("joueur", j);
					return "redirect:/menu";
				}
				return "connexion";
			}
		}
		
		return "connexion";
	}
}
