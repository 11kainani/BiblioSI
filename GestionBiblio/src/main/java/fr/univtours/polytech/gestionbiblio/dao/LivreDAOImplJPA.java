package fr.univtours.polytech.gestionbiblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.univtours.polytech.gestionbiblio.model.LivreBean;

public class LivreDAOImplJPA implements LivreDAO {

	private EntityManager em;

	public LivreDAOImplJPA() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionBiblio");
		this.em = emf.createEntityManager();
	}

	@Override
	public List<LivreBean> getLivreList() {
		Query requete = em.createQuery("select l from LivreBean l");
		return requete.getResultList();
	}

	public List<LivreBean> getLivreListWhithResearch(String author, String title, String genre, Boolean available) {
		String query = "select l from LivreBean l where 1=1 ";

		if (!author.isEmpty()) {
			query += "AND LOWER(l.auteur) LIKE '%" + author.toLowerCase() + "%'";

		}
		if (!title.isEmpty()) {
			query += " AND LOWER(l.titre) LIKE '%" + title.toLowerCase() + "%'";
		}
		if (!genre.isEmpty()) {
			query += " AND l.genre.nom = '" + genre + "'";
		}
		if (available) {
			query += " AND l.libre = true";
		}
		Query requete = em.createQuery(query);
		return requete.getResultList();
	}

	@Override
	public LivreBean getLivre(Integer id) {
		LivreBean livre = (LivreBean) em.find(LivreBean.class, id);
		return livre;
	}

	@Override
	public void insertLivre(LivreBean livre) {
		em.getTransaction().begin();
		em.persist(livre);
		em.getTransaction().commit();

	}

	@Override
	public void updateLivre(LivreBean livre) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			LivreBean livreToUpdate = em.find(LivreBean.class, livre.getId());
			livreToUpdate.setAuteur(livre.getAuteur());
			livreToUpdate.setTitre(livre.getTitre());
			livreToUpdate.setLibre(livre.isLibre());
			livreToUpdate.setGenre(livre.getGenre());
			livreToUpdate.setUtilisateur(livre.getUtilisateur());
			livreToUpdate.setDateEmprunt(livre.getDateEmprunt());
			livreToUpdate.setDateFinEmprunt(livre.getDateFinEmprunt());
			em.merge(livreToUpdate);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();

		}

	}
}
