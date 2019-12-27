package fr.formation.DAO.hibernate;

import java.util.List;

import fr.formation.Classe.Croisement;
import fr.formation.Classe.Croisement;
import fr.formation.DAO.IDAOCroisement;

public class DAOCroisementHibernate extends DAOHibernate implements IDAOCroisement {
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select a from Croisement a", Croisement.class).getResultList();
	}

	@Override
	public Croisement findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Croisement.class, id);
	}

	@Override
	public Croisement save(Croisement entity) {
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
	public void delete(Croisement entity) {
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
		Croisement leCroisementASupprimer = new Croisement();
		leCroisementASupprimer.setId(id);
		delete(leCroisementASupprimer);
	}
	
}