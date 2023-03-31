package fr.univtours.polytech.biblio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
public class GenreBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6543990775207764837L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    @OneToMany(mappedBy = "genre")
    private List<LivreBean> listLivres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<LivreBean> getListLivres() {
        return listLivres;
    }

    public void setListLivre(List<LivreBean> listLivres) {
        this.listLivres = listLivres;
    }

}
