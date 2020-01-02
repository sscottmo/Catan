package fr.formation.DAO.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public abstract class DAOHibernate {
	
	protected static EntityManagerFactory emf = null;
	protected EntityManager em = null;
	
	
	public DAOHibernate() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("CatanPersistenceUnit");
		}
		
		if (emf != null){
			this.em = emf.createEntityManager();
		}

		

	}
	public static void close() {
		if (emf != null){
			emf.close();
			emf = null;
		}
	}

	public void setEMF() {

		
	
}



}
