package fr.formation.Classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="utilisateur")
public abstract class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UTI_ID")
	private int id;

	@Column(name="UTI_PSEUDO",length = 100, nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String nom;

	@Column(name="UTI_MOT_DE_PASSE",length = 100, nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String motDePasse;
	
	@Column(name="UTI_EST_CONNECTE")
	private boolean estConnecte;
	
}
