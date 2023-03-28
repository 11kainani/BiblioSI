package fr.univtours.polytech.biblioEJB.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class UtilisateurBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4953632689772248437L;

	@Id
	private String identifiant;
	private String nom;
	private Integer age;
	private String motDePasse;
	private boolean admin;
	private List<LivreBean> listLivre;

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<LivreBean> getListLivre() {
		return listLivre;
	}

	public void setListLivre(List<LivreBean> listLivre) {
		this.listLivre = listLivre;
	}

}
