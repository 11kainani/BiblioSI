package fr.univtours.polytech.biblio.business;

import java.util.List;

import javax.ejb.Local;

import fr.univtours.polytech.biblio.model.GenreBean;

@Local
public interface GenreBusinessLocal {

    public List<GenreBean> getGenreList();

    public GenreBean getGenre(Integer id);

    public void insertGenre(GenreBean genre);

    public void updateGenre(GenreBean genre);

}

