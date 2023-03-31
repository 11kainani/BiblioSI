package fr.univtours.polytech.biblio.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.biblio.model.UtilisateurBean;

@Stateless
public class UtilisateurDAOImplJPA implements UtilisateurDAO {

    @PersistenceContext(unitName = "GestionBiblioEJB")
    private EntityManager em;

    public UtilisateurDAOImplJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionBiblio");
        this.em = emf.createEntityManager();
    }

    @Override
    public List<UtilisateurBean> getUtilisateurList() {
        Query requete = em.createQuery("select u from UtilisateurBean u");
        return requete.getResultList();

    }

    @Override
    public UtilisateurBean getUtilisateur(String id) {
        UtilisateurBean utilisateur = (UtilisateurBean) em.find(UtilisateurBean.class, id);
        return utilisateur;
    }

    @Override
    public void insertUtilisateur(UtilisateurBean utilisateur) {

        em.persist(utilisateur);


    }

    @Override
    public void updateUtilisateur(UtilisateurBean utilisateur) {

    }

    @Override
    public UtilisateurBean utilisateurExists(String login, String password) {

        UtilisateurBean utilisateur = (UtilisateurBean) em.find(UtilisateurBean.class, login);

        if (utilisateur != null) {
            if (utilisateur.getMotDePasse().equals(password)) {

                return utilisateur;
            } else {
                return null;
            }
        }
        return utilisateur;
    }

}
