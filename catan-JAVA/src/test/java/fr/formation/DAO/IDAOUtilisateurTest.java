package fr.formation.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.formation.Classe.Utilisateur;
import fr.formation.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ AppConfig.class })
public class IDAOUtilisateurTest {

	
	@Autowired
	public IDAOUtilisateur daoUtilisateur;
	

	@Test
	public void beanExisteBien() {
		assertNotNull(daoUtilisateur);
	}
	
	@Test 
	public void testFindByNom() {
		try {
			Optional<Utilisateur> optionalUtilisateur = daoUtilisateur.findByNom("maxou");
			assertNotNull(optionalUtilisateur);
			assertTrue(optionalUtilisateur.isPresent());
			assertEquals("maxou", optionalUtilisateur.get().getNom());
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	@Test 
	public void testFindByRecherchePartie() {
		try {
			List<Utilisateur> utilisateurs = daoUtilisateur.findByRecherchePartieTrue();
			utilisateurs.forEach(u -> {
				assertTrue(u.getRecherchePartie());
			});
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
