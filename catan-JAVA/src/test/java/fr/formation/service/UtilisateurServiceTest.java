package fr.formation.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.Classe.Utilisateur;
import fr.formation.DAO.IDAOUtilisateur;
import fr.formation.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ AppConfig.class })
public class UtilisateurServiceTest {

	@Autowired(required = false)
	private UtilisateurService servUtilisateur;

	@Autowired(required = false)
	private IDAOUtilisateur daoUtilisateur;
	
	@Test 
	@Transactional
	@Rollback(true)
	public void testInscription() {
		try {
//			Optional<Utilisateur> utilisateur = servUtilisateur.daoUtilisateur.findByNom("maxou");
			Utilisateur monUtilisateur = new Utilisateur(); 
			monUtilisateur.setNom("monNom");
			monUtilisateur.setMotDePasse("myPassword");
			assertEquals(0,monUtilisateur.getId());
//			daoUtilisateur.save(monUtilisateur);
			servUtilisateur.inscription("monNom","myPassword");
			assertEquals(1,daoUtilisateur.findByNomIs(monUtilisateur.getNom()).size());
			servUtilisateur.inscription("monNom","myPassword");
			assertEquals(1,daoUtilisateur.findByNomIs(monUtilisateur.getNom()).size());
			
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}
	

	@Test 
	@Transactional
	@Rollback(true)
	public void testAuthentification() {
		try {
//			Optional<Utilisateur> utilisateur = servUtilisateur.daoUtilisateur.findByNom("maxou");
			Utilisateur monUtilisateur = new Utilisateur(); 
			monUtilisateur.setNom("monNom");
			monUtilisateur.setMotDePasse("myPassword");
			daoUtilisateur.save(monUtilisateur);
			assertFalse(daoUtilisateur.findByNom("monNom").get().getEstConnecte());
			servUtilisateur.authentification("monNom", "myPassword");
			assertTrue(daoUtilisateur.findByNom("monNom").get().getEstConnecte());
			
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
