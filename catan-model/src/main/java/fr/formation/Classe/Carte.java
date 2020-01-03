package fr.formation.Classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "Carte")
public class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARTE_ID")
	private int id = 0;
	
	@Column(name="CARTE_CARTEDEV")
	@Enumerated(EnumType.STRING)
	private CarteDev carteDev;
	
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CARTE_JOUEUR")
	private Joueur joueur = null;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="CARTE_PARTIE")
	private Partie partie;
	
	
	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CarteDev getCarteDev() {
		return carteDev;
	}
	public void setCarteDev(CarteDev carteDev) {
		this.carteDev = carteDev;
	}
	
	
	


	
	
	
	
	
	
	
	
}
