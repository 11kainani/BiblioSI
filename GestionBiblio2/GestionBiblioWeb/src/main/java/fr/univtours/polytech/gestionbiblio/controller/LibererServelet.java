package fr.univtours.polytech.gestionbiblio.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univtours.polytech.biblio.business.GenreBusinessImpl;
import fr.univtours.polytech.biblio.business.GenreBusinessLocal;
import fr.univtours.polytech.biblio.business.LivreBusinessImpl;
import fr.univtours.polytech.biblio.business.LivreBusinessLocal;
import fr.univtours.polytech.biblio.business.UtilisateurBusinessImpl;
import fr.univtours.polytech.biblio.business.UtilisateurBusinessLocal;
import fr.univtours.polytech.biblio.model.GenreBean;
import fr.univtours.polytech.biblio.model.LivreBean;
import fr.univtours.polytech.biblio.model.UtilisateurBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/liberer")
public class LibererServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UtilisateurBusinessLocal utilisateurBusiness;
    @EJB
    private LivreBusinessLocal livreBusiness;
    @EJB
    private GenreBusinessLocal genreBusiness;

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

        // HttpSession session = request.getSession();
        // UtilisateurBean utilisateur = (UtilisateurBean)
        // session.getAttribute("UTILISATEUR");

        Integer IdLivre = Integer.parseInt(request.getParameter("rendreBookId"));
        LivreBean freedBook = this.livreBusiness.getLivre(IdLivre);
        UtilisateurBean userOfBook = freedBook.getUtilisateur();
        System.out.println("avant :" + userOfBook.getListLivres());
        userOfBook.getListLivres().remove(freedBook);
        System.out.println("apres :" + userOfBook.getListLivres());

        if (!freedBook.getDateEmprunt().equals(null)) {
            freedBook.setDateEmprunt(null);
        }

        if (!freedBook.getDateFinEmprunt().equals(null)) {
            freedBook.setDateFinEmprunt(null);
        }

        freedBook.setLibre(true);
        freedBook.setUtilisateur(null);

        this.livreBusiness.updateLivre(freedBook);
        // utilisateur.getListLivres().remove(freedBook);
        List<LivreBean> ListLivres = this.livreBusiness.getLivreList();
        List<GenreBean> ListGenres = this.genreBusiness.getGenreList();
        for (LivreBean livre : ListLivres) {
            System.out.println(livre.getTitre() + "is libre: " + livre.getLibre());
        }

        request.setAttribute("LIST_GENRES", ListGenres);
        request.setAttribute("LIST_LIVRES", ListLivres);

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
