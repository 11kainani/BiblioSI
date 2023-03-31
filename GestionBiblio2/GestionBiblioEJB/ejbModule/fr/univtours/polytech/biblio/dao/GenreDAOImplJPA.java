package fr.univtours.polytech.biblio.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.biblio.model.GenreBean;

@Stateless
public class GenreDAOImplJPA implements GenreDAO {

    @PersistenceContext(unitName = "GestionBiblioEJB")
    private EntityManager em;

    public GenreDAOImplJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionBiblio");
        this.em = emf.createEntityManager();
    }

    @Override
    public List<GenreBean> getGenreList() {
        Query requete = em.createQuery("select g from GenreBean g");
        return requete.getResultList();
    }

    @Override
    public GenreBean getGenre(Integer id) {
        GenreBean genre = (GenreBean) em.find(GenreBean.class, id);
        return genre;
    }

    @Override
    public void insertGenre(GenreBean genre) {

        em.persist(genre);

    }

    @Override
    public void updateGenre(GenreBean genre) {
        // TODO Auto-generated method stub

    }

}
