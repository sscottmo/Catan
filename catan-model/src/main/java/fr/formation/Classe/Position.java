package fr.formation.Classe;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="position")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="POS_ID")
	private int id;
	@Column(name = "POS_POS")
	@Size(max = 2)
	private int pos;
	@Column(name = "POS_VALEUR")
	@Size(max = 2)
	private int val;
	
	@Column(name = "POS_TYPE")
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@OneToOne(mappedBy="posBandit")
	private Partie bandit;

	@OneToMany(mappedBy="pos1")
	private List<Croisement> croisements1;
	@OneToMany(mappedBy="pos2")
	private List<Croisement> croisements2;
	@OneToMany(mappedBy="pos3")
	private List<Croisement> croisements3;
	
	@OneToMany(mappedBy="pos1")
	private List<Chemin> chemins1;
	@OneToMany(mappedBy="pos2")
	private List<Chemin> chemins2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public Position(int id, int pos, int val, Type type) {
		this.id = id;
		this.pos = pos;
		this.val = val;
		this.type = type;
	}
	public Position() {
		
	}
	public Partie getBandit() {
		return bandit;
	}
	public void setBandit(Partie bandit) {
		this.bandit = bandit;
	}
	public List<Croisement> getCroisements1() {
		return croisements1;
	}
	public void setCroisements1(List<Croisement> croisements1) {
		this.croisements1 = croisements1;
	}
	public List<Croisement> getCroisements2() {
		return croisements2;
	}
	public void setCroisements2(List<Croisement> croisements2) {
		this.croisements2 = croisements2;
	}
	public List<Croisement> getCroisements3() {
		return croisements3;
	}
	public void setCroisements3(List<Croisement> croisements3) {
		this.croisements3 = croisements3;
	}
	public List<Chemin> getChemins1() {
		return chemins1;
	}
	public void setChemins1(List<Chemin> chemins1) {
		this.chemins1 = chemins1;
	}
	public List<Chemin> getChemins2() {
		return chemins2;
	}
	public void setChemins2(List<Chemin> chemins2) {
		this.chemins2 = chemins2;
	}
	
}
