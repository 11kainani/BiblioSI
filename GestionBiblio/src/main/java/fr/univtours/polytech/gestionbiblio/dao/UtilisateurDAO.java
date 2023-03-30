package fr.univtours.polytech.gestionbiblio.dao;

import java.util.List;

import fr.univtours.polytech.gestionbiblio.model.UtilisateurBean;

public interface UtilisateurDAO {

	public List<UtilisateurBean> getUtilisateurList();

	public UtilisateurBean getUtilisateur(String id);

	public void insertUtilisateur(UtilisateurBean utilisateur);

	public void updateUtilisateur(UtilisateurBean utilisateur);

	public UtilisateurBean utilisateurExists(String login, String password);

}
