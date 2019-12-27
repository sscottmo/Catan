package fr.formation.DAO.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.Classe.Chemin;
import fr.formation.Classe.Couleur;
import fr.formation.Classe.Croisement;
import fr.formation.Classe.Joueur;
import fr.formation.Classe.Position;
import fr.formation.Classe.Type;

public class EntityManager extends DAOConnectionSQL {
	private List<Joueur> mesJoueurs = new ArrayList<Joueur>();
	private List<Position> mesPositions = new ArrayList<Position>();
	private List<Chemin> mesChemins = new ArrayList<Chemin>();
	private List<Croisement> mesCroisements = new ArrayList<Croisement>();

	public List<Joueur> getMesJoueurs() {
		return mesJoueurs;
	}

	public void setMesJoueurs(List<Joueur> mesJoueurs) {
		this.mesJoueurs = mesJoueurs;
	}

	public List<Position> getMesPositions() {
		return mesPositions;
	}

	public void setMesPositions(List<Position> mesPositions) {
		this.mesPositions = mesPositions;
	}

	public List<Chemin> getMesChemins() {
		return mesChemins;
	}

	public void setMesChemins(List<Chemin> mesChemins) {
		this.mesChemins = mesChemins;
	}

	public List<Croisement> getMesCroisements() {
		return mesCroisements;
	}

	public void setMesCroisements(List<Croisement> mesCroisements) {
		this.mesCroisements = mesCroisements;
	}

//	public Joueur getJoueur(int idJoueur) {
//
//		for (Joueur j : this.mesJoueurs) {
//			if (j.getId() == idJoueur) {
//				return j;
//			}
//
//		}
//		Joueur monJoueur = new Joueur();
//		if (connection != null) {
//				Statement myStatement = connection.createStatement();
//				ResultSet myResult;
//				myResult = myStatement.executeQuery("SELECT * FROM joueur WHERE JOUEUR_ID =" + idJoueur);
//				String util = myResult.getString("JOU_UTIL");
//				monJoueur.setUtilisateur(getUtilisateur(util));
//				int part = myResult.getInt("JOU_PARTIE");
//				monJoueur.setPartie(getPartie(part));
//				Couleur cou = Enum.valueOf(Couleur.class, myResult.getString("JOU_COULEUR"));
//				monJoueur.setBois(myResult.getInt("JOU_BOIS"));
//				monJoueur.setArgile(myResult.getInt("JOU_ARGILE"));
//				monJoueur.setLaine(myResult.getInt("JOU_LAINE"));
//				monJoueur.setBle(myResult.getInt("JOU_BLE"));
//				monJoueur.setMinerai(myResult.getInt("JOU_MINERAI"));
//				monJoueur.setArmee(myResult.getInt("JOU_ARMEE"));
//				monJoueur.setRouteLaPlusLongue(myResult.getInt("JOU_ROUTE"));
//
//				Couleur coul = Enum.valueOf(Couleur.class, myResult.getString("JOU_COULEUR"));
//				monJoueur.setCouleur(coul);
//
//		
//				mesJoueurs.add(monJoueur);
//
//				return monJoueur;
//		}
//	}
//
//	public Chemin getChemin(ResultSet result) {
//		int id = 0;
//		try {
//			id = result.getInt("CHEM_ID");
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for (Chemin c : this.mesChemins) {
//			if (c.getId() == id) {
//				return c;
//			}
//
//		}
//		Chemin monChemin = new Chemin();
//		int id1;
//		try {
//			id1 = result.getInt("CHEM_POS_1");
//
//		int id2 = result.getInt("CHEM_POS_2");
//		int idJoueur = result.getInt("CHEM_JOUEUR");
//		Position position1 = this.getPosition(id1);
//		Position position2 = this.getPosition(id2);
//		Joueur joueur = this.getJoueur(idJoueur);
//		ArrayList<Position> positions = new ArrayList<Position>();
//		positions.add(position1);
//		positions.add(position2);
//		monChemin.setChemin(positions);
//		monChemin.setId(id);
//		monChemin.setJoueur(joueur);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		mesChemins.add(monChemin);
//
//		return monChemin;
//	}
//
//	public Croisement getCroisement(ResultSet result) {
//		int id = 0;
//		try {
//			id = result.getInt("CROIS_ID");
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for (Croisement c : this.mesCroisements) {
//			if (c.getId() == id) {
//				return c;
//			}
//
//		}
//		Croisement monCroisement = new Croisement();
//		try {
//		int id1 = result.getInt("CROIS_POS_1");
//		int id2 = result.getInt("CROIS_POS_2");
//		int id3 = result.getInt("CROIS_POS_3");
//		int idJoueur = result.getInt("CHEM_JOUEUR");
//		boolean ville;
//		
//			ville = result.getBoolean("CROIS_VILLE");
//
//		Position position1 = this.getPosition(id1);
//		Position position2 = this.getPosition(id2);
//		Position position3 = this.getPosition(id3);
//		Joueur joueur = this.getJoueur(idJoueur);
//		ArrayList<Position> positions = new ArrayList<Position>();
//		positions.add(position1);
//		positions.add(position2);
//		positions.add(position3);
//		monCroisement.setCroisement(positions);
//		monCroisement.setId(id);
//		monCroisement.setJoueur(joueur);
//		monCroisement.setVille(ville);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		mesCroisements.add(monCroisement);
//
//		return monCroisement;
//	}
//
//	public Position getPosition(int id) {
//
//		for (Position p : this.mesPositions) {
//			if (p.getId() == id) {
//				return p;
//			}
//
//		}
//		Position maPosition = new Position();
//		if (connection != null) {
//			try {
//				Statement myStatement = connection.createStatement();
//				ResultSet myResult;
//				myResult = myStatement.executeQuery("SELECT * FROM position WHERE POS_ID =" + id);
//				maPosition.setId(myResult.getInt("POS_ID"));
//				maPosition.setType(Enum.valueOf(Type.class, myResult.getString("POS_TYPE")));
//				maPosition.setPos(myResult.getInt("POS_POS"));
//				maPosition.setVal(myResult.getInt("POS_VALEUR"));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//		mesPositions.add(maPosition);
//		return maPosition;

//	}
}
