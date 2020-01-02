package fr.formation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Partie;

public interface IDAOPartie extends JpaRepository<Partie,Integer>{

}
