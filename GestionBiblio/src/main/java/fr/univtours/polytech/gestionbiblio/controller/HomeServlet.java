package fr.univtours.polytech.gestionbiblio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univtours.polytech.gestionbiblio.business.GenreBusiness;
import fr.univtours.polytech.gestionbiblio.business.GenreBusinessImpl;
import fr.univtours.polytech.gestionbiblio.business.LivreBusiness;
import fr.univtours.polytech.gestionbiblio.business.LivreBusinessImpl;
import fr.univtours.polytech.gestionbiblio.business.UtilisateurBusiness;
import fr.univtours.polytech.gestionbiblio.business.UtilisateurBusinessImpl;
import fr.univtours.polytech.gestionbiblio.model.GenreBean;
import fr.univtours.polytech.gestionbiblio.model.LivreBean;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LivreBusiness livre;
	private GenreBusiness genre;
	private UtilisateurBusiness utilisateur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		this.livre = new LivreBusinessImpl();
		this.genre = new GenreBusinessImpl();
		this.utilisateur = new UtilisateurBusinessImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// LivreBusinessImpl livreBusinessImpl = new LivreBusinessImpl();

		// récupérer les paramètres de recherche
		String auteur = request.getParameter("author");
		if(auteur == null) {
			auteur = "";
		}
		String titre = request.getParameter("title");
		if(titre == null) {
			titre = "";
		}
		String genre = request.getParameter("genre");
		if(genre == null) {
			genre = "";
		}
		boolean available = "true".equals(request.getParameter("available"));

		List<LivreBean> ListLivres = this.livre.getLivreListWhithResearch(auteur,titre,genre,available);
		List<GenreBean> ListGenres = this.genre.getGenreList();		

		request.setAttribute("LIST_GENRES", ListGenres);
		request.setAttribute("LIST_LIVRES", ListLivres);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

}
