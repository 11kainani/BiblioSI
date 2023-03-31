package fr.univtours.polytech.biblio.dao;

import java.util.List;

import fr.univtours.polytech.biblio.model.LivreBean;
import fr.univtours.polytech.biblio.model.UtilisateurBean;

public interface LivreDAO {

    public List<LivreBean> getLivreList();

    public List<LivreBean> getLivreListWhithResearch(String author, String title, String genre, Boolean available);

    public LivreBean getLivre(Integer id);

    public void insertLivre(LivreBean livre);

    public void updateLivre(LivreBean livre);

    public List<LivreBean> getLivreListNotLibre();

    public List<LivreBean> getListByUser(UtilisateurBean user);

}
