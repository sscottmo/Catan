package fr.formation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
}
