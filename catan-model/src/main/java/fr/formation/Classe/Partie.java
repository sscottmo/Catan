package fr.formation.Classe;

import java.util.ArrayList;

import javax.persistence.OneToMany;

public class Partie {
	private int id;
	
	@OneToMany(mappedBy = "partie")
	private ArrayList<Joueur> joueurs;
	
	private ArrayList<Carte> pioche;
	private int bois;
	private int argile;
	private int laine;
	private int ble;
	private int minerai;
	private Position bandit;
}
