package fr.univtours.polytech.gestionbiblio.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univtours.polytech.biblio.business.LivreBusinessImpl;
import fr.univtours.polytech.biblio.business.LivreBusinessLocal;
import fr.univtours.polytech.biblio.business.UtilisateurBusinessImpl;
import fr.univtours.polytech.biblio.business.UtilisateurBusinessLocal;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/deconnecter")
public class DeconnecterServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UtilisateurBusinessLocal utilisateurBusiness;
    @EJB
    private LivreBusinessLocal livreBusiness;

    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
        this.utilisateurBusiness = new UtilisateurBusinessImpl();
        this.livreBusiness = new LivreBusinessImpl();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("UTILISATEUR");
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
