package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Position;

public interface IDAOPosition extends JpaRepository<Position,Integer>{

	
	public List<Position> findByIdLessThan(int max);


	}
