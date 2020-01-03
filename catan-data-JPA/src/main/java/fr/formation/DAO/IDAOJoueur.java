package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.Classe.Joueur;
import fr.formation.Classe.Utilisateur;

public interface IDAOJoueur extends JpaRepository<Joueur,Integer> {

	
	@Query("select u from Utilisateur u where u.recherchePartie = true")
	public List<Utilisateur> findUtilisateursPrets();
	
	@Query("update Utilisateur u set u.type = 1 where u.id = :id")
	@Modifying
	public void transUtilisateurEnJoueur(@Param("id") int id);
				
	@Query("select j from Joueur j where j.recherchePartie = true and j.type =1")
	public List<Joueur> findJoueursPrets();

}
