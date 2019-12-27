package fr.formation.DAO.hibernate;

import java.util.List;

import javax.persistence.Query;

import fr.formation.Classe.Position;
import fr.formation.Classe.Type;
import fr.formation.DAO.IDAOPosition;

public class DAOPositionHibernate extends DAOHibernate implements IDAOPosition {
	@Override
	public List<Position> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Position p", Position.class).getResultList();
	}

	@Override
	public Position findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Position.class, id);
	}

	@Override
	public Position save(Position entity) {
		// TODO Auto-generated method stub

		em.getTransaction().begin();
		try {
			if (entity.getId() == 0) {
				em.persist(entity); // AJOUT
			} else {
				entity = em.merge(entity);
			}
			em.getTransaction().commit(); // CHANGEMENT
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return entity;
	}

	@Override
	public void delete(Position entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
		

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Position lePositionASupprimer = new Position();
		lePositionASupprimer.setId(id);
		delete(lePositionASupprimer);
	}
	
	public List findAll(int min, int max){
	Query myQuery = em.createQuery("select p from Position p where (p.id>= :minimum and p.id<= :maximum)", Position.class);
	myQuery.setParameter("minimum", min);
	myQuery.setParameter("maximum", max);
	return myQuery.getResultList();
	}
}