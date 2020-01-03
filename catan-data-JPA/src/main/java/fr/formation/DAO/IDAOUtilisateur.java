package fr.formation.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer>{


}
