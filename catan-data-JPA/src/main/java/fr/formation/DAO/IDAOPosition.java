package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.Classe.Position;

public interface IDAOPosition extends JpaRepository<Position,Integer>{

	
	public List<Position> findByIdLessThan(int max);

	@Query("select p from Position p order by p.x, p.y")
	public List<Position> orderByPositions();

	}
