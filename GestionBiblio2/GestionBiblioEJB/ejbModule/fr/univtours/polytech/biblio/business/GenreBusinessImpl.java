package fr.univtours.polytech.biblio.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.biblio.dao.GenreDAO;
import fr.univtours.polytech.biblio.dao.GenreDAOImplJPA;
import fr.univtours.polytech.biblio.model.GenreBean;

@Stateless
public class GenreBusinessImpl implements GenreBusinessLocal, GenreBusinessRemote {

    @Inject
    private GenreDAO dao;

    public GenreBusinessImpl() {
        this.dao = new GenreDAOImplJPA();
    }

    @Override
    public List<GenreBean> getGenreList() {
        return dao.getGenreList();
    }

    @Override
    public GenreBean getGenre(Integer id) {
        return dao.getGenre(id);
    }

    @Override
    public void insertGenre(GenreBean genre) {
        dao.insertGenre(genre);

    }

    @Override
    public void updateGenre(GenreBean genre) {
        dao.updateGenre(genre);

    }

}
