package fr.univtours.polytech.gestionbiblio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univtours.polytech.gestionbiblio.business.UtilisateurBusiness;
import fr.univtours.polytech.gestionbiblio.business.UtilisateurBusinessImpl;
import fr.univtours.polytech.gestionbiblio.model.UtilisateurBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UtilisateurBusiness u_Business;

    @Override
    public void init() throws ServletException {
        this.u_Business = new UtilisateurBusinessImpl();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */

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
        UtilisateurBean utilisateur = u_Business.utilisateurExists(username, password);

        

        if (utilisateur == null) {
            String messageError = "login ou mot de passe incorrect";
            request.setAttribute("MESSAGE", messageError);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {

            session.setAttribute("UTILISATEUR", utilisateur);
            request.getRequestDispatcher("home.jsp").forward(request, response);

        }

    }
}
