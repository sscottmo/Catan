package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.Classe.Joueur;
import fr.formation.Classe.Partie;
import fr.formation.Classe.Position;

public interface IDAOPartie extends JpaRepository<Partie,Integer>{
	
	@Query("select p from Partie p inner join p.terrain t where t.type = Desert and t.partie = :laPartie")
	public Position findPositionDesert(@Param("laPartie") Partie partie);

}
