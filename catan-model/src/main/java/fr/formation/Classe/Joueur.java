package fr.formation.Classe;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.PositiveOrZero;


@Entity
@DiscriminatorValue("1")
public class Joueur extends Utilisateur {
	
	
	public int getRouteMax() {
		return routeMax;
	}
	public void setRouteMax(int routeMax) {
		this.routeMax = routeMax;
	}
	@ManyToOne
	@JoinColumn(name="JOU_PARTIE")
	private Partie partie;
	
	@Column(name="JOU_COULEUR")
	@Enumerated(EnumType.STRING)
	private Couleur couleur;
	
	@OneToMany(mappedBy = "joueur")
	private List<Croisement> mesCroisements;
	
	@OneToMany(mappedBy = "joueur")
	private List<Chemin> mesChemins;
	
	@Column(name = "JOU_BOIS")
	@PositiveOrZero
	private Integer bois = 0;
	
	@Column(name = "JOU_ARGILE")
	@PositiveOrZero
	private Integer argile = 0;
	
	@Column(name = "JOU_LAINE")
	@PositiveOrZero
	private Integer laine = 0;
	
	@Column(name = "JOU_BLE")
	@PositiveOrZero
	private Integer ble = 0;
	
	@Column(name = "JOU_MINERAI")
	@PositiveOrZero
	private Integer minerai = 0;
	
	
	@OneToMany(mappedBy="joueur")
	private List<Carte> main;
	
	@Column(name = "JOU_ARMEE")
	@PositiveOrZero
	private Integer armee = 0;
	
	@Column(name = "JOU_ROUTEMAX")
	@PositiveOrZero
	private Integer routeMax = 0;
	
	
	

	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public List<Croisement> getMesCroisements() {
		return mesCroisements;
	}
	public void setMesCroisements(List<Croisement> mesCroisements) {
		this.mesCroisements = mesCroisements;
	}
	public List<Chemin> getMesChemins() {
		return mesChemins;
	}
	public void setMesChemins(List<Chemin> mesChemins) {
		this.mesChemins = mesChemins;
	}
	public Integer getBois() {
		return bois;
	}
	public void setBois(int bois) {
		this.bois = bois;
	}
	public Integer getArgile() {
		return argile;
	}
	public void setArgile(int argile) {
		this.argile = argile;
	}
	public Integer getLaine() {
		return laine;
	}
	public void setLaine(int laine) {
		this.laine = laine;
	}
	public Integer getBle() {
		return ble;
	}
	public void setBle(int ble) {
		this.ble = ble;
	}
	public Integer getMinerai() {
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
	public Integer getArmee() {
		return armee;
	}
	public void setArmee(int armee) {
		this.armee = armee;
	}
	public Integer getRouteLaPlusLongue() {
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
