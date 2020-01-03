package fr.formation.DAO;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Croisement;

public interface IDAOCroisement extends JpaRepository<Croisement,Integer> {

	public List<Croisement> findByIdLessThan(int i);
	
	public Croisement findById(int id);
}
