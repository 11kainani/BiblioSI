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
@WebServlet("/liberer")
public class LibererServelet extends HttpServlet {
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
	    

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	    HttpSession session = request.getSession();
	    UtilisateurBean utilisateur = (UtilisateurBean) session.getAttribute("UTILISATEUR");
	  
	       Integer IdLivre = Integer.parseInt(request.getParameter("bookId"));
	        LivreBean freedBook = this.livreBusiness.getLivre(IdLivre);
	        
	        if(!freedBook.getDateEmprunt().equals(null))
	        {
	            freedBook.setDateEmprunt(null);
	        }
	        
	        if(!freedBook.getDateFinEmprunt().equals(null))
	        {
	            freedBook.setDateFinEmprunt(null);
	        }
	        
	        freedBook.setLibre(true);
	        freedBook.setUtilisateur(null);
	        
	        this.livreBusiness.updateLivre(freedBook);
	        utilisateur.getListLivres().remove(freedBook);
	        session.removeAttribute("UTILISATEUR");

	        List<LivreBean> ListLivresNonLibre = this.livreBusiness.getLivreListNotLibre();


	        request.setAttribute("LIST_EMPRUNT", ListLivresNonLibre); 
	       session.setAttribute("UTILISATEUR", utilisateur);
	       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	        dispatcher.forward(request, response);
	}
}
