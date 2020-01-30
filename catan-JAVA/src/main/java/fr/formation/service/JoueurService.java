package fr.formation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.Classe.Carte;
import fr.formation.Classe.CarteDev;
import fr.formation.Classe.Croisement;
import fr.formation.Classe.Joueur;
import fr.formation.DAO.IDAOJoueur;

@Service
public class JoueurService {

	@Autowired
	public IDAOJoueur daoJoueur;
	
	
	@Transactional
	public void inscription(String nom, String password) {
		Optional<Joueur> joueur = daoJoueur.findByPseudo(nom);
		if (joueur == null) {
			Joueur newJoueur = new Joueur();
			newJoueur.setPseudo(nom);
			newJoueur.setMotDePasse(password);
			daoJoueur.save(newJoueur);
		} else {
			System.out.println("Le nom d'utilisateur existe deja, veuillez choisir un autre nom");
		}

	}
	
	@Transactional
	public void authentification(String nom, String password) {
		Optional<Joueur> joueur = daoJoueur.findByPseudo(nom);
		// SI LE MOT DE PASSE EST LE BON ET QUE L UTILISATEUR N EST PAS DEJA CONNECTE
		if (password.equals(joueur.get().getMotDePasse()) & !joueur.get().getEstConnecte()) {
			joueur.get().setEstConnecte(true);
		} else {
			System.out.println("Echec de la connexion !");
			System.out.println("Le mot de passe ou le nom d utilisateur n est pas bon");
		}
			
	}
	
	
	
	
//	@Transactional
//	public Joueur routeLaPlusLongue() {
//		List<Joueur> joueurs = daoJoueur.findAll();
//		Joueur jAvecPlusLongueRoute = null;
//		int plusLongueRoute = 4;
//		for(Joueur j : joueurs) {
//			List<List<Chemin>> listeRoute = new ArrayList<List<Chemin>>();
//			List<Chemin> mesChemins = j.getMesChemins();
//			while(!mesChemins.isEmpty()) {
//				if(listeRoute.isEmpty()) {
//					List<Chemin> route = new ArrayList<Chemin>();
//					route.add(mesChemins.remove(0));
//					listeRoute.add(route);
//				}
//				boolean ajout=false;
//				for(Chemin c : mesChemins) {
//					if()
//				}
//				
//			}
//		}
//		return jAvecPlusLongueRoute;
//	}
//	
}
