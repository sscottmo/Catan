package fr.formation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Chemin;

public interface IDAOChemin extends JpaRepository<Chemin, Integer> {

}
