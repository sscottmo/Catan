package fr.formation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.Classe.Joueur;
import fr.formation.DAO.IDAOJoueur;

@Controller
public class AccueilController {
	
	private IDAOJoueur daoJoueur;

	@GetMapping(value="/formulaire")
	public String formulaire(Model model) {
		model.addAttribute("produit", new Joueur());
		return "accueil";
	}
	
	@PostMapping(value="/formulaire")
	public String ajoutProduit(@Valid @ModelAttribute Joueur joueur, BindingResult result, Model model) {
		
//		Fournisseur2 fournisseur = new Fournisseur2();
//		fournisseur.setNom("");
//		if (daoProduit.count() >=1 ) {
//			int id = java.lang.Math.toIntExact(daoProduit.count()+1);
//			produit.setId(id);
//			fournisseur.setId(3);
//		} else {
//			fournisseur.setId(3);
//		}
//		produit.setFournisseur(fournisseur);
		if (result.hasErrors()) {
			return "accueil";
		}
		daoJoueur.save(joueur);
		
		return "redirect:/listeProd";
		
	}
}
