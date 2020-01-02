package fr.formation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Classe.Croisement;

public interface IDAOCroisement extends JpaRepository<Croisement,Integer> {
	public void definitionDesPorts();
}
