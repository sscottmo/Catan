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
public class MenuController {
	

	@Autowired
	private IDAOJoueur daoJoueur;
	
	@GetMapping(value="/menu")
	public String findAll(HttpSession session, Model model) {
		model.addAttribute("joueurCo", session.getAttribute("joueur"));
		model.addAttribute("joueurs",daoJoueur.findAll());
//		return "/WEB-INF/views/listeProd.jsp";
		return "menu";
	}
	
	@PostMapping(value="/menu")
	public String ajoutProduit(@Valid @ModelAttribute Joueur joueur, BindingResult result, Model model) {

		
		if (result.hasErrors()) {
			return "redirect:/inscription";
		}
		
		
		return "redirect:/connexion";
		
	}
	
	@GetMapping(value="/deconnexion")
	public String deconnexion(HttpSession session, Model model) {
		session.removeAttribute("joueur");
		return "redirect:/connexion";
	}
}