package fr.univtours.polytech.gestionbiblio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univtours.polytech.gestionbiblio.business.UtilisateurBusinessImpl;
import fr.univtours.polytech.gestionbiblio.model.UtilisateurBean;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UtilisateurBusinessImpl u_Business;

    @Override
    public void init() throws ServletException {
        this.u_Business = new UtilisateurBusinessImpl();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UtilisateurBean user = new UtilisateurBean();
        user.setIdentifiant(request.getParameter("nom"));
        user.setPrenom(request.getParameter("prenom"));
        user.setNom(request.getParameter("nom"));        
        user.setAge(Integer.parseInt(((request.getParameter("age")))));
        user.setMotDePasse(request.getParameter("password"));
        if(request.getParameter("option").equals("Yes"))
        {
            user.setAdmin(true);
        }else
        {
            user.setAdmin(false);
        }
        
        try
        {
            
            u_Business.insertUtilisateur(user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response); 
        }catch (Exception e) {
            String message = "The user with this identifiant already exists";
        }
        doGet(request, response);
        
        
    }

}
