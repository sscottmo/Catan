package fr.formation.DAO;

import java.util.List;

import fr.formation.Classe.Carte;

public interface IDAOCarte extends IDAO<Carte> {

	List<Carte> melangePioche();

}
