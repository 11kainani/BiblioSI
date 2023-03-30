package fr.univtours.polytech.gestionbiblio.business;

import java.util.List;

import fr.univtours.polytech.gestionbiblio.model.UtilisateurBean;

public interface UtilisateurBusiness {

	public List<UtilisateurBean> getUtilisateurList();

	public UtilisateurBean getUtilisateur(Integer id);

	public void insertUtilisateur(UtilisateurBean utilisateur);

	public void updateUtilisateur(UtilisateurBean utilisateur);

	public UtilisateurBean utilisateurExists(String login, String password);

}
