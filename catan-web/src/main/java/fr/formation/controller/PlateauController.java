package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.Classe.Carte;
import fr.formation.Classe.CarteDev;
import fr.formation.Classe.Joueur;
import fr.formation.DAO.IDAOJoueur;
import fr.formation.DAO.IDAOPosition;
import fr.formation.Views.Views;

@Controller
public class PlateauController {

	@Autowired
	private IDAOPosition daoPosition;
	
	@Autowired
	private IDAOJoueur daoJoueur;
	
	
	@GetMapping(value="/plateau")
	@Transactional
	@JsonView(Views.JoueurEnPartie.class)
	public String plateau(Model model, HttpSession session) {
		
		model.addAttribute("joueurs", daoJoueur.findAll());
//		Joueur sessionJoueur=(Joueur)session.getAttribute("joueur");
		Joueur sessionJoueur = daoJoueur.findById(1).get();
		model.addAttribute("sessionJoueur",sessionJoueur);
		List<List<Integer>> mainJoueurs = new ArrayList<List<Integer>>();
		for(Joueur j : daoJoueur.findAll()) {
			if (j.getPartie() != null) {
				List<Integer> mainJoueur = new ArrayList<Integer>();
				mainJoueur.add(j.getId());
				mainJoueur.add(j.getMain().size());
				mainJoueurs.add(mainJoueur);
			}
			if (sessionJoueur.getId() == j.getId()) {
				sessionJoueur.setMain(j.getMain());
			}
		}
		model.addAttribute("mainJoueurs", mainJoueurs);
		

		System.out.println(sessionJoueur.getId());
		System.out.println(sessionJoueur.getPseudo());
		System.out.println(sessionJoueur.getMain());
		List<Integer> carteDev = new ArrayList<Integer>();
		int chevalier=0;
		int PDV=0;
		int constructeur=0;
		int decouverte=0;
		int monopole=0;
		for (Carte c : sessionJoueur.getMain()) {
			if (c.getCarteDev() == CarteDev.Chevalier) {chevalier++;}
			if (c.getCarteDev() == CarteDev.PointDeVictoire) {PDV++;}
			if (c.getCarteDev() == CarteDev.ProgresRoute) {constructeur++;}
			if (c.getCarteDev() == CarteDev.ProgresDecouverte) {decouverte++;}
			if (c.getCarteDev() == CarteDev.ProgresMonopole) {monopole++;}
		}
		carteDev.add(chevalier);
		carteDev.add(PDV);
		carteDev.add(constructeur);
		carteDev.add(decouverte);
		carteDev.add(monopole);
		model.addAttribute("carteDev", carteDev);
		
		model.addAttribute("positions", daoPosition.orderByPositions());
		
//		List<List<Position>> plateau = new ArrayList<List<Position>>();
//		List<Position> positions = daoPosition.orderByPositions();
//		for (int i=1; i<8 ; i++) {
//			int s = i;
//			List<Position> ligne = new ArrayList<Position>();
//			positions.forEach(p -> {
//				if (p.getX() == s) {
//					ligne.add(p);
//					positions.remove(p);
//				
//				p.getLesCroisements().forEach(c-> c.getPositionsOtherThan(p));;
//				p.getLesChemins().forEach(c-> c.getPositionsOtherThan(p));
//				}
//			});
//			plateau.add(ligne);
//		}
//		List plateau = new ArrayList();
//		List<Position> positions = daoPosition.orderByPositions();
//		List<Croisement> croisementsExistants = new ArrayList<Croisement>();
//		List<Chemin> cheminsExistants = new ArrayList<Chemin>();
//		
//		
//		for (int i=1; i<8 ; i++) {
//			int s = i;
//			
//			
//			List ligne = new ArrayList();
//			positions.forEach(p -> {
//				if (p.getX() == s) {
//					List colonne = new ArrayList();
//					colonne.add(p);
//					List<Croisement> croisements = p.getLesCroisements();
//					croisementsExistants.forEach(c ->{
//						if (croisements.contains(c)) {
//							croisements.remove(c);
//						}
//					});
//
//					List<Chemin> chemins =p.getLesChemins();
//					cheminsExistants.forEach(c ->{
//						if (chemins.contains(c)) {
//							chemins.remove(c);
//						}
//					});
//					
//					croisements.forEach(c -> {
//						c.trouverPosture(p);
//					});
//					
//					chemins.forEach(c -> {
//						c.trouverPosture(p);
//					});
//					
//					colonne.add(croisements);
//					colonne.add(chemins);
//					
//					croisementsExistants.addAll(croisements);
//					cheminsExistants.addAll(chemins);
//					positions.remove(p);
//					
//					ligne.add(colonne);
//				}
//			});
//			plateau.add(ligne);
//		}
		
//		model.addAttribute("plateau", plateau );
		return "plateau";
	}}
