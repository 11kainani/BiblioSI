package fr.univtours.polytech.gestionbiblio.business;

import java.util.List;

import fr.univtours.polytech.gestionbiblio.model.LivreBean;

public interface LivreBusiness {

	public List<LivreBean> getLivreList();

	public List<LivreBean> getLivreListWhithResearch(String author, String title, String genre, Boolean available);

	public LivreBean getLivre(Integer id);

	public void insertLivre(LivreBean livre);

	public void updateLivre(LivreBean livre);

}
