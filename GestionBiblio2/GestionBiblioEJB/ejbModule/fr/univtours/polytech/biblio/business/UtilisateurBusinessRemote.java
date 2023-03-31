package fr.univtours.polytech.biblio.business;

import java.util.List;

import javax.ejb.Remote;

import fr.univtours.polytech.biblio.model.UtilisateurBean;

@Remote
public interface UtilisateurBusinessRemote {

    public List<UtilisateurBean> getUtilisateurList();

    public UtilisateurBean getUtilisateur(String id);

    public void insertUtilisateur(UtilisateurBean utilisateur);

    public void updateUtilisateur(UtilisateurBean utilisateur);

    public UtilisateurBean utilisateurExists(String login, String password);

}

