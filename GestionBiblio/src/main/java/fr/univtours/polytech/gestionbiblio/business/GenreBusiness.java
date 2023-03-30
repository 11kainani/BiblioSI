package fr.univtours.polytech.gestionbiblio.business;

import java.util.List;

import fr.univtours.polytech.gestionbiblio.model.GenreBean;

public interface GenreBusiness {

	public List<GenreBean> getGenreList();

	public GenreBean getGenre(Integer id);

	public void insertGenre(GenreBean genre);

	public void updateGenre(GenreBean genre);

}
