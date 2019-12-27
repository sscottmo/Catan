package fr.formation.DAO.hibernate;

import java.util.List;

import fr.formation.Classe.Chemin;
import fr.formation.DAO.IDAOChemin;

public class DAOCheminHibernate extends DAOHibernate implements IDAOChemin {
	@Override
	public List<Chemin> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Chemin c", Chemin.class).getResultList();
	}

	@Override
	public Chemin findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Chemin.class, id);
	}

	@Override
	public Chemin save(Chemin entity) {
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
	public void delete(Chemin entity) {
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
		Chemin leCheminASupprimer = new Chemin();
		leCheminASupprimer.setId(id);
		delete(leCheminASupprimer);
	}
	
}
