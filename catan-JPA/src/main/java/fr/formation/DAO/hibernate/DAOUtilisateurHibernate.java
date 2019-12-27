package fr.formation.DAO.hibernate;

import java.util.ArrayList;
import java.util.List;

import fr.formation.Classe.Utilisateur;
import fr.formation.DAO.IDAOUtilisateur;

public class DAOUtilisateurHibernate extends DAOHibernate implements IDAOUtilisateur{
	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
	}

	@Override
	public Utilisateur findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Utilisateur.class, id);
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
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
	public void delete(Utilisateur entity) {
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
		Utilisateur lUtilisateurASupprimer = new Utilisateur();
		lUtilisateurASupprimer.setId(id);
		delete(lUtilisateurASupprimer);
	}
	
	
	public List<Utilisateur> commencerPartie(){
		return em.createQuery("select u from Utilisateur u where u.recherchePartie = true", Utilisateur.class).getResultList();
	}
	
	public List<Utilisateur> choisirJoueur(){
		List<Utilisateur> joueurs = new ArrayList <Utilisateur>();
		joueurs = em.createQuery("select u from Utilisateur u where u.recherchePartie = true", Utilisateur.class).getResultList();
		while (joueurs.size()>4) {
			joueurs.remove(joueurs.get(1));
		}
		joueurs.forEach(j -> {j.setRecherchePartie(false);
								this.save(j);
								});
		
		return joueurs;
	}
	
}
