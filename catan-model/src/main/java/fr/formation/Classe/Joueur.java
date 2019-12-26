package fr.formation.Classe;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Joueur")
public class Joueur extends Utilisateur {
	
	
	@ManyToOne
	@JoinColumn(name="JOU_PARTIE")
	private Partie partie;
	
	
	private Couleur couleur;
	
	@OneToMany(mappedBy = "joueur")
	private ArrayList<Croisement> mesCroisements;
	
	@OneToMany(mappedBy = "joueur")
	private ArrayList<Chemin> mesChemins = null;
	
	private int bois = 0;
	private int argile = 0;
	private int laine = 0;
	private int ble = 0;
	private int minerai = 0;
	
	
	@OneToMany(mappedBy="joueurCarte")
	private ArrayList<Carte> mesCartes;
	
	private int armee = 0;
	private int routeLaPlusLongue = 0;
	
	
	

	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public ArrayList<Croisement> getMesCroisements() {
		return mesCroisements;
	}
	public void setMesCroisements(ArrayList<Croisement> mesCroisements) {
		this.mesCroisements = mesCroisements;
	}
	public ArrayList<Chemin> getMesChemins() {
		return mesChemins;
	}
	public void setMesChemins(ArrayList<Chemin> mesChemins) {
		this.mesChemins = mesChemins;
	}
	public int getBois() {
		return bois;
	}
	public void setBois(int bois) {
		this.bois = bois;
	}
	public int getArgile() {
		return argile;
	}
	public void setArgile(int argile) {
		this.argile = argile;
	}
	public int getLaine() {
		return laine;
	}
	public void setLaine(int laine) {
		this.laine = laine;
	}
	public int getBle() {
		return ble;
	}
	public void setBle(int ble) {
		this.ble = ble;
	}
	public int getMinerai() {
		return minerai;
	}
	public void setMinerai(int minerai) {
		this.minerai = minerai;
	}
	public ArrayList<Carte> getMesCartes() {
		return mesCartes;
	}
	public void setMesCartes(ArrayList<Carte> mesCartes) {
		this.mesCartes = mesCartes;
	}
	public int getArmee() {
		return armee;
	}
	public void setArmee(int armee) {
		this.armee = armee;
	}
	public int getRouteLaPlusLongue() {
		return routeLaPlusLongue;
	}
	public void setRouteLaPlusLongue(int routeLaPlusLongue) {
		this.routeLaPlusLongue = routeLaPlusLongue;
	}

	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
}
