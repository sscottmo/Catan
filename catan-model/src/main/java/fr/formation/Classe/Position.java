package fr.formation.Classe;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	private List<Croisement> croisement2;
	@OneToMany(mappedBy="pos3")
	private List<Croisement> croisement3;
	
	@OneToMany(mappedBy="pos1")
	private List<Chemin> chemin1;
	@OneToMany(mappedBy="pos2")
	private List<Chemin> chemin2;
	
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
}
