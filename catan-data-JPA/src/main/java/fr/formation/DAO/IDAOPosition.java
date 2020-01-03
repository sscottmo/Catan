package fr.formation.DAO;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.Classe.Joueur;
import fr.formation.Classe.Position;

public interface IDAOPosition extends JpaRepository<Position,Integer>{

	
	public List<Position> findByIdLessThan(int max);


	}
