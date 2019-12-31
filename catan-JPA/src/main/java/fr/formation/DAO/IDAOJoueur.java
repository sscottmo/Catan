package fr.formation.DAO;

import java.util.List;

import fr.formation.Classe.Joueur;
import fr.formation.Classe.Utilisateur;

public interface IDAOJoueur extends IDAO<Joueur> {

	void choisirJoueurs();
	
	Joueur trans(Utilisateur utilisateur);

	List<Joueur> affecterJoueurs();
}
