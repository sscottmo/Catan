package fr.formation.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Joueur;

public interface IDAOJoueur extends JpaRepository<Joueur,Integer> {


	public Optional<Joueur> findByPseudo(String pseudo);

	public List<Optional<Joueur>> findByPseudoIs(String pseudo);
	
	public List<Joueur> findByRecherchePartieTrue();
	
//	@Query("select u from Utilisateur u where u.recherchePartie = true")
//	public List<Joueur> findJoueurPrets();
	
	
	

}
