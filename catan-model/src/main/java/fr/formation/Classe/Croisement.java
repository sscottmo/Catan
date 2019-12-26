package fr.formation.Classe;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Croisement")
public class Croisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="POS_ID")
	private int id;
	
	@OneToOne
	@JoinColumn(name="CROIS_POS_1")
	private Position pos1;
	@OneToOne
	@JoinColumn(name="CROIS_POS_2")
	private Position pos2;
	@OneToOne
	@JoinColumn(name="CROIS_POS_3")
	private Position pos3;
	
	@ManyToOne
	@JoinColumn(name = "CROIS_JOUEUR")
	private Joueur joueur;

	@Column(name="CROIS_VILLE")
	private boolean ville = false;
	@Column(name="CROIS_ACCES_PORT")
	private boolean accesPort = false;
	
	
	public Position getPos1() {
		return pos1;

	public ArrayList<Position> getCroisement() {
		ArrayList<Position> croisement = new ArrayList<Position>();
		croisement.add(pos1);
		croisement.add(pos2);
		croisement.add(pos3);
		return croisement;
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

}
