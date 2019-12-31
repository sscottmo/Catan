package fr.formation.Classe;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "UTI_TYPE", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID")
	private int id;

	@Column(name = "UTI_PSEUDO", length = 100, nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String nom;

	@Column(name = "UTI_MOT_DE_PASSE", length = 100, nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String motDePasse;

	@Column(name = "UTI_EST_CONNECTE")
	private Boolean estConnecte;

	@Column(name = "UTI_RECHERCHE_PARTIE")
	private Boolean recherchePartie = false;

	@Column(name = "UTI_TYPE", insertable = false, updatable = false)
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(boolean estConnecte) {
		this.estConnecte = estConnecte;
	}

	public boolean isRecherchePartie() {
		return recherchePartie;
	}

	public void setRecherchePartie(boolean recherchePartie) {
		this.recherchePartie = recherchePartie;
	}

	public Boolean getEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(Boolean estConnecte) {
		this.estConnecte = estConnecte;
	}

	public Boolean getRecherchePartie() {
		return recherchePartie;
	}

	public void setRecherchePartie(Boolean recherchePartie) {
		this.recherchePartie = recherchePartie;
	}
}
