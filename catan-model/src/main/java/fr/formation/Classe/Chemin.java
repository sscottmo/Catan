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

@Entity
@Table(name = "Chemin")
public class Chemin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CHEM_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CHEM_POS_1")
	private Position pos1;
	@ManyToOne
	@JoinColumn(name="CHEM_POS_2")
	private Position pos2;
	@ManyToOne
	@JoinColumn(name="CHEM_JOUEUR")
	private Joueur joueur;

	public Position getPos1() {
		return pos1;
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
	
	
	public List<Position> getChemin() {
		List<Position> chemin = new ArrayList<Position>();
		chemin.add(pos1);
		chemin.add(pos2);
		return chemin;
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
	
	
}
