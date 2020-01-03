package fr.formation.Classe;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "Partie")
public class Partie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PART_ID")
	private int id;
	
	@OneToMany(mappedBy = "partie")
	@Cascade(CascadeType.ALL)
	private List<Joueur> joueurs;
	
	@OneToMany(mappedBy = "partie")
	@Cascade(CascadeType.ALL)
	private List<Carte> pioche;
	
	@Column(name = "PART_BOIS")
	@PositiveOrZero
	private int bois = 19;
	
	@Column(name = "PART_ARGILE")
	@PositiveOrZero
	private int argile = 19;
	
	@Column(name = "PART_LAINE")
	@PositiveOrZero
	private int laine = 19;
	
	@Column(name = "PART_BLE")
	@PositiveOrZero
	private int ble = 19;
	
	@Column(name = "PART_MINERAI")
	@PositiveOrZero
	private int minerai = 19;
	
	@OneToOne
	@JoinColumn(name="PART_POS_BANDIT")
	@Cascade(CascadeType.ALL)
	private Position posBandit;
	
	@OneToMany(mappedBy = "partie")
	@Cascade(CascadeType.ALL)
	private List<Position> terrain;
	
	@OneToMany(mappedBy = "partie")
	@Cascade(CascadeType.ALL)
	private Set<Croisement> croisements;
	
	@OneToMany(mappedBy = "partie")
	@Cascade(CascadeType.ALL)
	private Set<Chemin> chemins;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public List<Carte> getPioche() {
		return pioche;
	}

	public void setPioche(List<Carte> pioche) {
		this.pioche = pioche;
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

	public Position getPosBandit() {
		return posBandit;
	}

	public void setPosBandit(Position posBandit) {
		this.posBandit = posBandit;
	}

	public List<Position> getTerrain() {
		return terrain;
	}

	public void setTerrain(List<Position> terrain) {
		this.terrain = terrain;
	}

	public Set<Croisement> getCroisements() {
		return croisements;
	}

	public void setCroisements(Set<Croisement> croisements) {
		this.croisements = croisements;
	}

	public Set<Chemin> getChemins() {
		return chemins;
	}

	public void setChemins(Set<Chemin> chemins) {
		this.chemins = chemins;
	}


	
	
}
