package fr.formation.Classe;

import java.util.ArrayList;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Chemin {
	private ArrayList<Position> chemin;
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CHEM_JOUEUR")
	private Joueur joueur;
	
	
	public ArrayList<Position> getChemin() {
		return chemin;
	}
	public void setChemin(ArrayList<Position> chemin) {
		this.chemin = chemin;
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
