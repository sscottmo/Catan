package fr.formation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.Classe.Carte;
import fr.formation.Classe.Chemin;
import fr.formation.Classe.Couleur;
import fr.formation.Classe.Croisement;
import fr.formation.Classe.Joueur;
import fr.formation.Classe.Partie;
import fr.formation.Classe.Position;
import fr.formation.Classe.Type;
import fr.formation.Classe.TypePort;
import fr.formation.Classe.TypeTerre;
import fr.formation.DAO.IDAOCarte;
import fr.formation.DAO.IDAOCroisement;
import fr.formation.DAO.IDAOJoueur;
import fr.formation.DAO.IDAOPartie;
import fr.formation.DAO.IDAOPosition;

@Service
public class PartieService {

	@Autowired
	IDAOJoueur daoJoueur;
	@Autowired
	IDAOPartie daoPartie;
	@Autowired
	IDAOPosition daoPosition;
	@Autowired
	IDAOCroisement daoCroisement;
	@Autowired
	IDAOCarte daoCarte;

//	@Transactional
//	public void choisirJoueurs() {
//		List<Utilisateur> futursJoueurs = daoJoueur.findUtilisateursPrets();
//
//		while (futursJoueurs.size() > 4) {
//			futursJoueurs.remove(3);
//		}
//
//		for (Utilisateur u : futursJoueurs) {
//			daoJoueur.transUtilisateurEnJoueur(u.getId());
//		}
//		return;
//	}

	@Transactional
	public void affecterJoueurs(Partie partie) {
		List<Joueur> joueurs = daoJoueur.findByRecherchePartieTrue();
		List<Couleur> lesCouleurs = new ArrayList<Couleur>(Arrays.asList(Couleur.values()));

		while (joueurs.size() > 4) {
			joueurs.remove(3);
		}

		joueurs.forEach(j -> {
			j.setRecherchePartie(false);
			j.setCouleur(lesCouleurs.remove(0));
			j.setArgile(0);
			j.setBois(0);
			j.setMinerai(0);
			j.setLaine(0);
			j.setBle(0);
			j.setPartie(partie);

		});
		partie.setJoueurs(joueurs);
		return;
	}

	@Transactional
	public void affecterTerrain(Partie partie) {
		this.definitionDesPorts();
		List<Position> positions = daoPosition.findByIdLessThan(38);
		Set<Croisement> croisements = new HashSet<Croisement>();
		Set<Chemin> chemins = new HashSet<Chemin>();
		positions.forEach(p -> {
//			p.setId(0);         POUR FAIRE PLUSIEURS PARTIES ON NE PEUT PAS FAIRE DES COPIES EN AFFECTANT ID=0, IL FAUT CREER DES NOUVEAUX CROISEMENTS, CHEMINS, POSITIONS
			p.setPartie(partie);
			p.getCroisements1().forEach(c -> {
//				c.setId(0);
				c.setPartie(partie);
				croisements.add(c);
			});
			p.getCroisements2().forEach(c -> {
//				c.setId(0);
				c.setPartie(partie);
				croisements.add(c);
			});
			p.getCroisements3().forEach(c -> {
//				c.setId(0);
				c.setPartie(partie);
				croisements.add(c);
			});
			p.getChemins1().forEach(c -> {
//				c.setId(0);
				c.setPartie(partie);
				chemins.add(c);
			});
			p.getChemins2().forEach(c -> {
//				c.setId(0);
				c.setPartie(partie);
				chemins.add(c);
			});

		});

		this.attribuerTypes(positions);

		partie.setTerrain(positions);
		partie.setCroisements(croisements);
		partie.setChemins(chemins);

	}

	@Transactional
	private void attribuerTypes(List<Position> positions) {

		List<TypeTerre> toRandom = new ArrayList<TypeTerre>();
		for (TypeTerre t : TypeTerre.values()) {
			for (int i = 0; i < t.getOccurences(); i++) {
				toRandom.add(TypeTerre.valueOf(t.name()));
			}
		}
		Collections.shuffle(toRandom);
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
	}

	@Transactional
	public void definitionDesPorts() {
		List<Croisement> mesCroisements = daoCroisement.findByIdLessThan(55);
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
			Croisement crois = mesCroisements.get(i-1);
			crois.setAccesPort(true);
		}
	}

	@Transactional
	public List<Carte> melangePioche() {
		List<Carte> pioche = daoCarte.findByIdLessThan(26);
		Collections.shuffle(pioche);
//		pioche.forEach(c -> c.setId(0));  IDEM, id=0 IMPOSSIBLE POUR FAIRE LA COPIE DES CARTES
		return pioche;
	}

	@Transactional
	public void affecterPioche(Partie partie) {
		List<Carte> pioche = this.melangePioche();
		pioche.forEach(c-> c.setPartie(partie));		
		partie.setPioche(pioche);
	}

	@Transactional
	public Partie creationPartie() {
		Partie maPartie = new Partie();
		this.affecterJoueurs(maPartie);
		this.affecterTerrain(maPartie);
		this.affecterPioche(maPartie);
		daoPartie.save(maPartie);
		maPartie.setPosBandit(daoPartie.findPositionDesert());
		daoPartie.save(maPartie);

		return maPartie;
	}

}
