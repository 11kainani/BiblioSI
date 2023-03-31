package fr.univtours.polytech.biblio.business;

import java.util.List;

import javax.inject.Inject;

import fr.univtours.polytech.biblio.dao.LivreDAO;
import fr.univtours.polytech.biblio.dao.LivreDAOImplJPA;
import fr.univtours.polytech.biblio.model.LivreBean;
import fr.univtours.polytech.biblio.model.UtilisateurBean;

public class LivreBusinessImpl implements LivreBusinessLocal, LivreBusinessRemote {

    @Inject
    private LivreDAO dao;

    public LivreBusinessImpl() {
        this.dao = new LivreDAOImplJPA();
    }

    @Override
    public List<LivreBean> getLivreList() {
        return dao.getLivreList();
    }

    public List<LivreBean> getLivreListWhithResearch(String author, String title, String genre, Boolean available) {
        return dao.getLivreListWhithResearch(author, title, genre, available);
    }

    @Override
    public LivreBean getLivre(Integer id) {
        return dao.getLivre(id);
    }

    @Override
    public void insertLivre(LivreBean livre) {
        dao.insertLivre(livre);

    }

    @Override
    public void updateLivre(LivreBean livre) {
        dao.updateLivre(livre);

    }

    @Override
    public List<LivreBean> getLivreListNotLibre() {
        return dao.getLivreListNotLibre();

    }

    @Override
    public List<LivreBean> getListByUser(UtilisateurBean user) {
        return dao.getListByUser(user);
    }

}