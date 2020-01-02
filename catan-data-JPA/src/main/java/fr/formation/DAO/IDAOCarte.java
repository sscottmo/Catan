package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Carte;

public interface IDAOCarte extends JpaRepository<Carte,Integer> {

	List<Carte> melangePioche();

}
