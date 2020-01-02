package fr.formation.DAO.hibernate;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.formation.Classe.Croisement;
import fr.formation.DAO.IDAOCroisement;

@Repository
public class DAOCroisementHibernate extends DAOHibernate implements IDAOCroisement {
	@Override
	public List<Croisement> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Croisement c", Croisement.class).getResultList();
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
		} catch (Exception e) {
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
		} catch (Exception e) {
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

	public void definitionDesPorts() {
		List<Croisement> mesCroisements = this.findAll();
		mesCroisements.forEach(c -> c.setAccesPort(false));

		List<Integer> positionsPorts = new ArrayList<Integer>(
				Arrays.asList(27, 30, 33, 34, 37, 40, 43, 44, 47, 50, 53, 54));
		List<Integer> posPort1 = Arrays.asList(26, 28);
		List<Integer> posPort2 = Arrays.asList(29, 31);
		List<Integer> posPort3 = Arrays.asList(36, 38);
		List<Integer> posPort4 = Arrays.asList(39, 41);
		List<Integer> posPort5 = Arrays.asList(46, 48);
		List<Integer> posPort6 = Arrays.asList(49, 51);

		Collections.shuffle(posPort1);
		positionsPorts.add(posPort1.get(0));
		Collections.shuffle(posPort2);
		positionsPorts.add(posPort2.get(0));
		Collections.shuffle(posPort3);
		positionsPorts.add(posPort3.get(0));
		Collections.shuffle(posPort4);
		positionsPorts.add(posPort4.get(0));
		Collections.shuffle(posPort5);
		positionsPorts.add(posPort5.get(0));
		Collections.shuffle(posPort6);
		positionsPorts.add(posPort6.get(0));

		for (Integer i : positionsPorts) {
			Croisement crois = this.findById(i);
			crois.setAccesPort(true);
			this.save(crois);
		}
	}
}