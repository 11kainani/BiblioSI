package fr.univtours.polytech.gestionbiblio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univtours.polytech.gestionbiblio.business.GenreBusiness;
import fr.univtours.polytech.gestionbiblio.business.GenreBusinessImpl;
import fr.univtours.polytech.gestionbiblio.business.LivreBusiness;
import fr.univtours.polytech.gestionbiblio.business.LivreBusinessImpl;
import fr.univtours.polytech.gestionbiblio.business.UtilisateurBusiness;
import fr.univtours.polytech.gestionbiblio.business.UtilisateurBusinessImpl;
import fr.univtours.polytech.gestionbiblio.model.GenreBean;
import fr.univtours.polytech.gestionbiblio.model.LivreBean;
import fr.univtours.polytech.gestionbiblio.model.UtilisateurBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurBusiness utilisateurBusiness;
	private LivreBusiness livreBusiness;
	private GenreBusiness genreBusiness;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		this.utilisateurBusiness = new UtilisateurBusinessImpl();
		this.livreBusiness = new LivreBusinessImpl();
		this.genreBusiness = new GenreBusinessImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		UtilisateurBean utilisateur = utilisateurBusiness.utilisateurExists(username, password);

		if (utilisateur == null) {
			String messageError = "login ou mot de passe incorrect";
			request.setAttribute("MESSAGE", messageError);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {

			List<LivreBean> ListLivres = this.livreBusiness.getLivreList();
			List<GenreBean> ListGenres = this.genreBusiness.getGenreList();

			for (LivreBean livre : ListLivres) {
				System.out.println(livre.getTitre()+"is libre: " + livre.getLibre());
			}

			request.setAttribute("LIST_GENRES", ListGenres);
			request.setAttribute("LIST_LIVRES", ListLivres);
			session.setAttribute("UTILISATEUR", utilisateur);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}

	}
}
