//package fr.formation.DAO;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import fr.formation.Classe.Utilisateur;
//
//public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer>{
//
//	public Optional<Utilisateur> findByNom(String nom);
//
//	public List<Optional<Utilisateur>> findByNomIs(String nom);
//	
////	public void authentification(String nom, String password);
////	
////	public List<Utilisateur> choisirJoueurs();
//	public List<Utilisateur> findByRecherchePartieTrue();// ANCIENNEMENT commencerPartie
//}
