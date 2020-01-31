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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.Views.Views;

@Entity
@Table(name = "Croisement")
public class Croisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CROIS_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_POS_1")
	@JsonView({Views.Croisement.class,Views.JoueurCalculPoint.class})
	private Position pos1;
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_POS_2")
	@JsonView({Views.Croisement.class,Views.JoueurCalculPoint.class})
	private Position pos2;
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_POS_3")
	@JsonView({Views.Croisement.class,Views.JoueurCalculPoint.class})
	private Position pos3;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CROIS_JOUEUR")
	@JsonView({Views.Croisement.class,Views.JoueurEnPartie.class})
	private Joueur joueur;

	@Column(name="CROIS_VILLE")
	@JsonView({Views.Croisement.class,Views.JoueurCalculPoint.class})
	private Boolean ville = false;
	
	@Column(name="CROIS_ACCES_PORT")
	@JsonView(Views.Croisement.class)
	private Boolean accesPort = false;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CROIS_PARTIE")
	@JsonView(Views.Croisement.class)
	private Partie partie;
	
	@JsonView(Views.Croisement.class)
	private PostureCroisement posture;
	
	
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
	
	public List<Position> getPositions() {
		List<Position> croisement = new ArrayList<Position>();
		croisement.add(pos1);
		croisement.add(pos2);
		croisement.add(pos3);
		return croisement;
	}
	public List<Position> getPositionsOtherThan(Position p) {
		List<Position> positions = new ArrayList<Position>();
		if (pos1.getId() != p.getId()) {
			positions.add(pos1);
		}
		if (pos2.getId() != p.getId()) {
			positions.add(pos2);
		}
		if (pos3.getId() != p.getId()) {
			positions.add(pos3);
		}
		return positions;
	}
	public PostureCroisement getPosture() {
		return posture;
	}
	public void setPosture(PostureCroisement posture) {
		this.posture = posture;
	}
	
	public void trouverPosture(Position p) {
		Position pos1 = this.getPositionsOtherThan(p).get(0);
		Position pos2 = this.getPositionsOtherThan(p).get(1);
		float x = ((float)(pos1.getX()+pos2.getX()))/2;
		float y = ((float)(pos1.getY()+pos2.getY()))/2;
		float xP = (float) p.getX();
		float yP = (float) p.getY();

			if (y < yP) {
				if(x< xP) {
					this.setPosture(PostureCroisement.hautgauche);
				}
				else {
					this.setPosture(PostureCroisement.basgauche);
				}
			}
			else if (y == yP) {
				if(x< xP) {
					this.setPosture(PostureCroisement.haut);
				}
				else {
					this.setPosture(PostureCroisement.bas);
				}
			}
			else {
				if(x< xP) {
					this.setPosture(PostureCroisement.hautdroite);
				}
				else {
					this.setPosture(PostureCroisement.basdroite);
				}
			}
		

		}

}
