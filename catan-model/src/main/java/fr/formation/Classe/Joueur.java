package fr.formation.Classe;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "joueur")
public class Joueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOU_ID")
	private int id;

	@Column(name = "JOU_PSEUDO", length = 100, nullable = false)
	@NotEmpty(message = "Le pseudo est obligatoire")
	@Size(max = 100)
	private String pseudo;

	@Column(name = "JOU_MOT_DE_PASSE", length = 20, nullable = false)
	@NotEmpty(message = "Le mot de passe est obligatoire (de 4 à 20 caractères)")
	@Size(min = 4, max = 20, message = "Le mot de passe doit faire entre 4 et 20 caractères")
	private String motDePasse;

	@Column(name = "JOU_MAIL", length = 100)
	@Size(max = 100)
	private String mail;

	@Column(name = "JOU_EST_CONNECTE")
	private Boolean estConnecte;

	@Column(name = "JOU_RECHERCHE_PARTIE")
	private Boolean recherchePartie = false;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="JOU_PARTIE")
	private Partie partie;
	
	@Column(name="JOU_COULEUR")
	@Enumerated(EnumType.STRING)
	private Couleur couleur;
	
	@OneToMany(mappedBy = "joueur")
	@Cascade(CascadeType.ALL)
	private List<Croisement> mesCroisements;
	
	@OneToMany(mappedBy = "joueur")
	@Cascade(CascadeType.ALL)
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
	@Cascade(CascadeType.ALL)
	private List<Carte> main;
	
	@Column(name = "JOU_ARMEE")
	@PositiveOrZero
	private Integer armee = 0;
	
	@Column(name = "JOU_ROUTEMAX")
	@PositiveOrZero
	private Integer routeMax = 0;
	
	
	

	public int getRouteMax() {
		return routeMax;
	}
	public void setRouteMax(int routeMax) {
		this.routeMax = routeMax;
	}
	public void setBois(Integer bois) {
		this.bois = bois;
	}
	public void setArgile(Integer argile) {
		this.argile = argile;
	}
	public void setLaine(Integer laine) {
		this.laine = laine;
	}
	public void setBle(Integer ble) {
		this.ble = ble;
	}
	public void setMinerai(Integer minerai) {
		this.minerai = minerai;
	}
	public void setArmee(Integer armee) {
		this.armee = armee;
	}
	public void setRouteMax(Integer routeMax) {
		this.routeMax = routeMax;
	}
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Boolean getEstConnecte() {
		return estConnecte;
	}
	public void setEstConnecte(Boolean estConnecte) {
		this.estConnecte = estConnecte;
	}
	public Boolean getRecherchePartie() {
		return recherchePartie;
	}
	public void setRecherchePartie(Boolean recherchePartie) {
		this.recherchePartie = recherchePartie;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
