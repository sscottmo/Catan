package fr.formation.DAO.hibernate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.formation.Classe.Position;
import fr.formation.Classe.Type;
import fr.formation.Classe.TypePort;
import fr.formation.Classe.TypeTerre;
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
		} catch (Exception e) {
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
		} catch (Exception e) {
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

	public void attributionDesTypes() {
		this.findAll().forEach(p -> System.out.println(p.getId() + " " + p.getType()));

		List<TypeTerre> toRandom = new ArrayList<TypeTerre>();
		for (TypeTerre t : TypeTerre.values()) {
			for (int i = 0; i < t.getOccurences(); i++) {
				toRandom.add(TypeTerre.valueOf(t.name()));
			}
		}
		Collections.shuffle(toRandom);
		List<Position> positions = this.findAll();
		for (int i = 1; i < 19; i++) {
			positions.get(i).setType(Type.valueOf(toRandom.remove(0).name()));
		}
		
		List<TypePort> toRandomPort = new ArrayList<TypePort>();
		for (TypePort t : TypePort.values()) {
			for (int i = 0; i < t.getOccurences(); i++) {
				toRandomPort.add(TypePort.valueOf(t.name()));
			}
		}
		Collections.shuffle(toRandomPort);
		for (int i = 19; i < 28; i++) {
			positions.get(i).setType(Type.valueOf(toRandomPort.remove(0).name()));
		}
		
		for (Position p : positions) {
			this.save(p);
		}
	}
}