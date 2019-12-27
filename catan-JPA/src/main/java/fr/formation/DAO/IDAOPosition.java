package fr.formation.DAO;

import java.util.List;
import java.util.Optional;

import fr.formation.Classe.Position;
import fr.formation.Classe.Type;

public interface IDAOPosition extends IDAO<Position>{

	public List findAll(int min, int max);
}
