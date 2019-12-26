package fr.formation.Classe;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;


@Entity
@Table(name = "Partie")
public class Partie {
	private int id;
	
	@OneToMany(mappedBy = "partie")
	private ArrayList<Joueur> joueurs;
	
	@OneToMany(mappedBy = "partie")
	private ArrayList<Carte> pioche;
	
	@Column(name = "PART_BOIS")
	@PositiveOrZero
	private int bois;
	
	@Column(name = "PART_ARGILE")
	@PositiveOrZero
	private int argile;
	
	@Column(name = "PART_LAINE")
	@PositiveOrZero
	private int laine;
	
	@Column(name = "PART_BLE")
	@PositiveOrZero
	private int ble;
	
	@Column(name = "PART_MINERAI")
	@PositiveOrZero
	private int minerai;
	
	@OneToOne
	@JoinColumn(name="PART_POS_BANDIT")
	private Position posBandit;
}
