package fr.formation.Classe;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;


@Entity
public class Joueur extends Utilisateur {
	
	
	@ManyToOne
	@JoinColumn(name="JOU_PARTIE")
	private Partie partie;
	
	@Column(name="JOU_COULEUR")
	@Enumerated(EnumType.STRING)
	private Couleur couleur;
	
	@OneToMany(mappedBy = "joueur")
	private ArrayList<Croisement> mesCroisements;
	
	@OneToMany(mappedBy = "joueur")
	private ArrayList<Chemin> mesChemins;
	
	@Column(name = "JOU_BOIS")
	@PositiveOrZero
	private int bois = 0;
	
	@Column(name = "JOU_ARGILE")
	@PositiveOrZero
	private int argile = 0;
	
	@Column(name = "JOU_LAINE")
	@PositiveOrZero
	private int laine = 0;
	
	@Column(name = "JOU_BLE")
	@PositiveOrZero
	private int ble = 0;
	
	@Column(name = "JOU_MINERAI")
	@PositiveOrZero
	private int minerai = 0;
	
	
	@OneToMany(mappedBy="joueur")
	private List<Carte> main;
	
	@Column(name = "JOU_ARMEE")
	@PositiveOrZero
	private int armee = 0;
	
	@Column(name = "JOU_ROUTEMAX")
	@PositiveOrZero
	private int routeMax = 0;
	
	
	

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
	public List<Carte> getMain() {
		return main;
	}
	public void setMain(List<Carte> mesCartes) {
		this.main = mesCartes;
	}
	public int getArmee() {
		return armee;
	}
	public void setArmee(int armee) {
		this.armee = armee;
	}
	public int getRouteLaPlusLongue() {
		return routeMax;
	}
	public void setRouteLaPlusLongue(int routeLaPlusLongue) {
		this.routeMax = routeLaPlusLongue;
	}

	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
}
