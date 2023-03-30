package fr.univtours.polytech.gestionbiblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.univtours.polytech.gestionbiblio.model.LivreBean;
import fr.univtours.polytech.gestionbiblio.model.UtilisateurBean;

public class UtilisateurDAOImplJPA implements UtilisateurDAO {

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
    public UtilisateurBean getUtilisateur(Integer id) {
        UtilisateurBean utilisateur = (UtilisateurBean) em.find(UtilisateurBean.class, id);
        return utilisateur;
    }

    @Override
    public void insertUtilisateur(UtilisateurBean utilisateur) {
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();

    }

    @Override
    public void updateUtilisateur(UtilisateurBean utilisateur) {
        // TODO Auto-generated method stub

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
