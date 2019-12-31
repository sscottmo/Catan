package fr.formation.DAO.hibernate;

import java.util.Collections;
import java.util.List;

import fr.formation.Classe.Carte;
import fr.formation.DAO.IDAOCarte;

public class DAOCarteHibernate extends DAOHibernate implements IDAOCarte {
	@Override
	public List<Carte> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Carte c", Carte.class).getResultList();
	}

	@Override
	public Carte findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Carte.class, id);
	}

	@Override
	public Carte save(Carte entity) {
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
	public void delete(Carte entity) {
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
		Carte leCarteASupprimer = new Carte();
		leCarteASupprimer.setId(id);
		delete(leCarteASupprimer);
	}
	
	public List<Carte> melangePioche() {
		List<Carte> pioche = this.findAll();
		Collections.shuffle(pioche);
		return pioche;
	}
	
}
