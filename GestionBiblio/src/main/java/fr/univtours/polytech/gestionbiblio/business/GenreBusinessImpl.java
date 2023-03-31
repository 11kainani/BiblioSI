package fr.univtours.polytech.gestionbiblio.business;

import java.util.List;

import fr.univtours.polytech.gestionbiblio.dao.GenreDAO;
import fr.univtours.polytech.gestionbiblio.dao.GenreDAOImplJPA;
import fr.univtours.polytech.gestionbiblio.model.GenreBean;

//@Stateless
public class GenreBusinessImpl implements GenreBusiness {

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
