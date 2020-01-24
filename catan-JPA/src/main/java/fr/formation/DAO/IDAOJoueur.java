package fr.formation.DAO;

import java.util.List;

import fr.formation.Classe.Joueur;

public interface IDAOJoueur extends IDAO<Joueur> {

	void choisirJoueurs();

//	Joueur trans(Utilisateur utilisateur);

	List<Joueur> affecterJoueurs();
}
