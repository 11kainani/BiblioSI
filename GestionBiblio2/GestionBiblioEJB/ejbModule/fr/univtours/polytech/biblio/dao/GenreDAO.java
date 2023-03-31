package fr.univtours.polytech.biblio.dao;

import java.util.List;

import fr.univtours.polytech.biblio.model.GenreBean;

public interface GenreDAO {

    public List<GenreBean> getGenreList();

    public GenreBean getGenre(Integer id);

    public void insertGenre(GenreBean genre);

    public void updateGenre(GenreBean genre);

}
