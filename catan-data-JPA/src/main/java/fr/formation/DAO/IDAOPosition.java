package fr.formation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Position;

public interface IDAOPosition extends JpaRepository<Position,Integer>{

	public void attributionDesTypes();
	}
