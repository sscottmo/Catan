package fr.formation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.Classe.Utilisateur;
import fr.formation.DAO.IDAOUtilisateur;

@Service
public class UtilisateurService {

	@Autowired
	public IDAOUtilisateur daoUtilisateur;
	
	
	@Transactional
	public void inscription(String nom, String password) {
		Optional<Utilisateur> utilisateur = daoUtilisateur.findByNom(nom);
		if (utilisateur == null) {
			Utilisateur newUtilisateur = new Utilisateur();
			newUtilisateur.setNom(nom);
			newUtilisateur.setMotDePasse(password);
			daoUtilisateur.save(newUtilisateur);
		} else {
			System.out.println("Le nom d'utilisateur existe deja, veuillez choisir un autre nom");
		}

	}
	
	@Transactional
	public void authentification(String nom, String password) {
		Optional<Utilisateur> utilisateur = daoUtilisateur.findByNom(nom);
		// SI LE MOT DE PASSE EST LE BON ET QUE L UTILISATEUR N EST PAS DEJA CONNECTE
		if (password.equals(utilisateur.get().getMotDePasse()) & !utilisateur.get().getEstConnecte()) {
			utilisateur.get().setEstConnecte(true);
		} else {
			System.out.println("Echec de la connexion !");
			System.out.println("Le mot de passe ou le nom d utilisateur n est pas bon");
		}
			
	}
	
}
