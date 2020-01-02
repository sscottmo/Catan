package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Joueur;
import fr.formation.Classe.Utilisateur;

public interface IDAOJoueur extends JpaRepository<Joueur,Integer> {

	void choisirJoueurs();
	
	Joueur trans(Utilisateur utilisateur);

	List<Joueur> affecterJoueurs();
}
