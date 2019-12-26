package fr.formation.Classe;

import java.util.ArrayList;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Croisement {
	private ArrayList<Position> croisement;
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CROIS_JOUEUR")
	private Joueur joueur;
	
	private boolean ville = false;
	private boolean accesPort = false;
	public ArrayList<Position> getCroisement() {
		return croisement;
	}
	public void setCroisement(ArrayList<Position> croisement) {
		this.croisement = croisement;
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
