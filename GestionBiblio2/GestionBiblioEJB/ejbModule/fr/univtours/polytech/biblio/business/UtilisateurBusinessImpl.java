package fr.univtours.polytech.biblio.business;

import java.util.List;

import javax.inject.Inject;

import fr.univtours.polytech.biblio.dao.UtilisateurDAO;
import fr.univtours.polytech.biblio.dao.UtilisateurDAOImplJPA;
import fr.univtours.polytech.biblio.model.UtilisateurBean;

public class UtilisateurBusinessImpl implements UtilisateurBusinessLocal, UtilisateurBusinessRemote {

    @Inject
    private UtilisateurDAO dao;

    public UtilisateurBusinessImpl() {
        this.dao = new UtilisateurDAOImplJPA();
    }

    @Override
    public List<UtilisateurBean> getUtilisateurList() {
        return dao.getUtilisateurList();
    }

    @Override
    public UtilisateurBean getUtilisateur(String id) {
        return dao.getUtilisateur(id);
    }

    @Override
    public void insertUtilisateur(UtilisateurBean utilisateur) {
        dao.insertUtilisateur(utilisateur);

    }

    @Override
    public void updateUtilisateur(UtilisateurBean utilisateur) {
        dao.updateUtilisateur(utilisateur);

    }

    @Override
    public UtilisateurBean utilisateurExists(String login, String password) {
        return dao.utilisateurExists(login, password);
    }

}
