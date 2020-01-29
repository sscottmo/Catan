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
@Table(name = "Chemin")
public class Chemin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHEM_ID")
	private int id;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CHEM_POS_1")
	private Position pos1;
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CHEM_POS_2")
	private Position pos2;
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CHEM_JOUEUR")
	private Joueur joueur;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CHEM_PARTIE")
	private Partie partie;
	
	private PostureChemin posture;


	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

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

	public List<Position> getPositions() {
		List<Position> chemin = new ArrayList<Position>();
		chemin.add(pos1);
		chemin.add(pos2);
		return chemin;
	}

	public List<Position> getPositionsOtherThan(Position p) {
		List<Position> positions = new ArrayList<Position>();
		if (pos1.getId() != p.getId()) {
			positions.add(pos1);
		}
		else if (pos2.getId() != p.getId()) {
			positions.add(pos2);
		}
		return positions;
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

	public PostureChemin getPosture() {
		return posture;
	}

	public void setPosture(PostureChemin posture) {
		this.posture = posture;
	}
	
	public void trouverPosture(Position p) {
		Position posAdjacente = this.getPositionsOtherThan(p).get(0);
		int x = posAdjacente.getX();
		int xP = p.getX();
		int y = posAdjacente.getY();
		int yP = p.getY();
		
		if (x < xP) {
			if (y < yP) {
				this.setPosture(PostureChemin.gauchehaut);
			}
			else {
				this.setPosture(PostureChemin.droitehaut);
			}
		}
		else if (x == xP) {
			if (y < yP) {
				this.setPosture(PostureChemin.gauche);
			}
			else {
				this.setPosture(PostureChemin.droite);
			}
		}
		else {
			if (y < yP) {
				this.setPosture(PostureChemin.gauchebas);
			}
			else {
				this.setPosture(PostureChemin.droitebas);
			}
		}
	}

}
