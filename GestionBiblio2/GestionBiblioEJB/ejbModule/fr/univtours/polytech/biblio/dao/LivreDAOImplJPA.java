package fr.univtours.polytech.biblio.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.biblio.model.LivreBean;
import fr.univtours.polytech.biblio.model.UtilisateurBean;

@Stateless
public class LivreDAOImplJPA implements LivreDAO {

    @PersistenceContext(unitName = "GestionBiblioEJB")
    private EntityManager em;

    public LivreDAOImplJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionBiblio");
        this.em = emf.createEntityManager();
    }

    @Override
    public List<LivreBean> getLivreList() {
        Query requete = em.createQuery("select l from LivreBean l");
        return requete.getResultList();
    }

    public List<LivreBean> getLivreListWhithResearch(String author, String title, String genre, Boolean available) {
        String query = "select l from LivreBean l where 1=1 ";

        if (!author.isEmpty()) {
            query += "AND LOWER(l.auteur) LIKE '%" + author.toLowerCase() + "%'";

        }
        if (!title.isEmpty()) {
            query += " AND LOWER(l.titre) LIKE '%" + title.toLowerCase() + "%'";
        }
        if (!genre.isEmpty()) {
            query += " AND l.genre.nom = '" + genre + "'";
        }
        if (available) {
            query += " AND l.libre = true";
        }
        Query requete = em.createQuery(query);
        return requete.getResultList();
    }

    @Override
    public LivreBean getLivre(Integer id) {
        LivreBean livre = (LivreBean) em.find(LivreBean.class, id);
        return livre;
    }

    @Override
    public void insertLivre(LivreBean livre) {

        em.persist(livre);

    }

    @Override
    public void updateLivre(LivreBean livre) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            LivreBean livreToUpdate = em.find(LivreBean.class, livre.getId());
            livreToUpdate.setAuteur(livre.getAuteur());
            livreToUpdate.setTitre(livre.getTitre());
            livreToUpdate.setLibre(livre.getLibre());
            livreToUpdate.setGenre(livre.getGenre());
            livreToUpdate.setUtilisateur(livre.getUtilisateur());
            livreToUpdate.setDateEmprunt(livre.getDateEmprunt());
            livreToUpdate.setDateFinEmprunt(livre.getDateFinEmprunt());
            em.merge(livreToUpdate);
            // em.clear();
            // em.refresh(livreToUpdate);
            tx.commit();
            // em.flush();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();

        }

    }

    @Override
    public List<LivreBean> getLivreListNotLibre() {
        Query requete = em.createQuery("select l from LivreBean l where libre = false");
        return requete.getResultList();

    }

    @Override
    public List<LivreBean> getListByUser(UtilisateurBean user) {
        Query requete = em.createQuery("from LivreBean where identifiant = " + user.getIdentifiant());
        return requete.getResultList();
    }
}
