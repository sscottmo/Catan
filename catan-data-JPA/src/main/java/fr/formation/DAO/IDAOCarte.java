package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Carte;
import fr.formation.Classe.Croisement;

public interface IDAOCarte extends JpaRepository<Carte,Integer> {

	public List<Carte> findByIdLessThan(int i);

}
