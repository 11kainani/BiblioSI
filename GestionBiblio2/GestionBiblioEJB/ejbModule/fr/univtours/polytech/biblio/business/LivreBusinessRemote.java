package fr.univtours.polytech.biblio.business;

import java.util.List;

import javax.ejb.Remote;

import fr.univtours.polytech.biblio.model.LivreBean;
import fr.univtours.polytech.biblio.model.UtilisateurBean;

@Remote
public interface LivreBusinessRemote {

    public List<LivreBean> getLivreList();

    public List<LivreBean> getLivreListWhithResearch(String author, String title, String genre, Boolean available);

    public LivreBean getLivre(Integer id);

    public void insertLivre(LivreBean livre);

    public void updateLivre(LivreBean livre);

    public List<LivreBean> getLivreListNotLibre();

    public List<LivreBean> getListByUser(UtilisateurBean user);

}
