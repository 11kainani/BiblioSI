package fr.univtours.polytech.biblio.business;

import java.util.List;

import javax.ejb.Remote;

import fr.univtours.polytech.biblio.model.GenreBean;

@Remote
public interface GenreBusinessRemote {

    public List<GenreBean> getGenreList();

    public GenreBean getGenre(Integer id);

    public void insertGenre(GenreBean genre);

    public void updateGenre(GenreBean genre);

}