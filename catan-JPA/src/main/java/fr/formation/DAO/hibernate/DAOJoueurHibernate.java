package fr.formation.DAO.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.formation.Classe.Couleur;
import fr.formation.Classe.Joueur;
import fr.formation.Classe.Utilisateur;
import fr.formation.DAO.IDAOJoueur;

public class DAOJoueurHibernate extends DAOHibernate implements IDAOJoueur {
	@Override
	public List<Joueur> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Joueur c", Joueur.class).getResultList();
	}

	@Override
	public Joueur findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Joueur.class, id);
	}

	@Override
	public Joueur save(Joueur entity) {
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
	public void delete(Joueur entity) {
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
		Joueur leJoueurASupprimer = new Joueur();
		leJoueurASupprimer.setId(id);
		delete(leJoueurASupprimer);
	}

	public void choisirJoueurs() {
		List<Utilisateur> utilisateurs = new ArrayList <Utilisateur>();
		utilisateurs = em.createQuery("select u from Utilisateur u where u.recherchePartie = true", Utilisateur.class).getResultList();
		
		while (utilisateurs.size()>4) {
			utilisateurs.remove(3);
		}
		
		for (Utilisateur u : utilisateurs) {
			this.trans(u);
		}
		return;
	}

	
	public List<Joueur> affecterJoueurs(){
		List<Joueur> joueurs = em.createQuery("select j from Joueur j where j.recherchePartie = true and j.type =1", Joueur.class).getResultList();
		List<Couleur> lesCouleurs = new ArrayList<Couleur>(Arrays.asList(Couleur.values()));
		
		while (joueurs.size()>4) {
			joueurs.remove(3);
		}
		
		joueurs.forEach (j->{
			j.setRecherchePartie(false);
			j.setCouleur(lesCouleurs.remove(0));
			j.setArgile(0);
			j.setBois(0);
			j.setMinerai(0);
			j.setLaine(0);
			j.setBle(0);

			this.save(j); }
		);
		return joueurs;
		}

	@Override
	public Joueur trans(Utilisateur utilisateur) {
		Joueur joueur = null;
		
		try {
			em.getTransaction().begin();
			
			em.createQuery("update Utilisateur u set u.type = 1 where u.id = :id")
				.setParameter("id", utilisateur.getId())
				.executeUpdate();
			
			em.getTransaction().commit();
			
//			joueur = em.createQuery("select j from Joueur j where j.id = :id", Joueur.class)
//						.setParameter("id", utilisateur.getId())
//						.getSingleResult();
		}
		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		return joueur;
	}
}
