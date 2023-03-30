package fr.univtours.polytech.gestionbiblio.business;

import java.util.List;

import fr.univtours.polytech.gestionbiblio.dao.LivreDAO;
import fr.univtours.polytech.gestionbiblio.dao.LivreDAOImplJPA;
import fr.univtours.polytech.gestionbiblio.model.LivreBean;

public class LivreBusinessImpl implements LivreBusiness {

	private LivreDAO dao;

	public LivreBusinessImpl() {
		this.dao = new LivreDAOImplJPA();
	}

	@Override
	public List<LivreBean> getLivreList() {
		return dao.getLivreList();
	}
	
	public List<LivreBean> getLivreListWhithResearch(String author,String title,String genre,Boolean available) {
		return dao.getLivreListWhithResearch(author,title,genre,available);
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

}
