package fr.formation.DAO;

import java.util.List;

import fr.formation.Classe.Utilisateur;

public interface IDAOUtilisateur extends IDAO<Utilisateur>{

	public List<Utilisateur> commencerPartie();
	
	public List<Utilisateur> choisirJoueurs();
}
