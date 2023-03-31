package fr.univtours.polytech.gestionbiblio.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class LivreBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3373362418869410073L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String auteur = "";
    private String titre = "";
    private boolean libre;

    @Column(columnDefinition = "DATE")
    private LocalDate dateEmprunt;

    @Column(columnDefinition = "DATE")
    private LocalDate dateFinEmprunt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdGenre")
    private GenreBean genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Identifiant")
    private UtilisateurBean utilisateur;

    public GenreBean getGenre() {
        return genre;
    }

    public void setGenre(GenreBean genre) {
        this.genre = genre;
    }

    public UtilisateurBean getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurBean utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean getLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateFinEmprunt() {
        return dateFinEmprunt;
    }

    public void setDateFinEmprunt(LocalDate dateFinEmprunt) {
        this.dateFinEmprunt = dateFinEmprunt;
    }

}
