package fr.formation.Classe;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Croisement")
public class Croisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CROIS_ID")
	private int id;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_POS_1")
	private Position pos1;
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_POS_2")
	private Position pos2;
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_POS_3")
	private Position pos3;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CROIS_JOUEUR")
	private Joueur joueur;

	@Column(name="CROIS_VILLE")
	private Boolean ville = false;
	
	@Column(name="CROIS_ACCES_PORT")
	private Boolean accesPort = false;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_PARTIE")
	private Partie partie;
	
	
	public Position getPos1() {
		return pos1;
	}
	public Boolean getVille() {
		return ville;
	}
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	public void setVille(Boolean ville) {
		this.ville = ville;
	}
	public Boolean getAccesPort() {
		return accesPort;
	}
	public void setAccesPort(Boolean accesPort) {
		this.accesPort = accesPort;
	}
	public void setPos1(Position pos1) {
		this.pos1 = pos1;
	}
	public Position getPos2() {
		return pos2;
	}
	public void setPos2(Position pos2) {
		this.pos2 = pos2;
	}
	public Position getPos3() {
		return pos3;
	}
	public void setPos3(Position pos3) {
		this.pos3 = pos3;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public boolean isVille() {
		return ville;
	}

	public void setVille(boolean ville) {
		this.ville = ville;
	}

	public boolean isAccesPort() {
		return accesPort;
	}

	public void setAccesPort(boolean accesPort) {
		this.accesPort = accesPort;
	}
	
	public List<Position> getCroisement() {
		List<Position> croisement = new ArrayList<Position>();
		croisement.add(pos1);
		croisement.add(pos2);
		croisement.add(pos3);
		return croisement;
	}

}
