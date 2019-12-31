package fr.formation.DAO.hibernate;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.formation.Classe.Partie;
import fr.formation.DAO.IDAOPartie;

public class DAOPartieHibernate extends DAOHibernate implements IDAOPartie{
	@Override
	public List<Partie> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Partie p", Partie.class).getResultList();
	}

	@Override
	public Partie findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Partie.class, id);
	}

	@Override
	@Cascade({CascadeType.MERGE,CascadeType.PERSIST})
	public Partie save(Partie entity) {
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
	public void delete(Partie entity) {
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
		Partie lePartieASupprimer = new Partie();
		lePartieASupprimer.setId(id);
		delete(lePartieASupprimer);
	}
	
}