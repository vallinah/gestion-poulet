package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.PouletDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.Poulet;

public class TraitementCharge {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
        } catch (Exception e) {
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        try {
            double poidsInitial = Double.parseDouble(request.getParameter("poidsInitial"));
            double poidsFinal = Double.parseDouble(request.getParameter("poidsFinal"));
            double poidsGrow = Double.parseDouble(request.getParameter("poidsGrow"));
            double prixDeVente = Double.parseDouble(request.getParameter("prixDeVente"));
            double cout = Double.parseDouble(request.getParameter("cout"));
            PouletDAO dao = new PouletDAO();


            Poulet poulet = new Poulet(0, poidsInitial, poidsFinal, poidsGrow, prixDeVente, cout);
    
            // Vérification de l'action à effectuer
            if (request.getParameter("pouletId") != null) {
                poulet.setId(Integer.parseInt((String) request.getParameter("pouletId")));
                dao.update(poulet);
            } else {
                dao.insert(poulet);
            }
            request.getRequestDispatcher("insertPoulet.jsp"); 
    
           // Redirection vers la page des clients après traitement
        } catch (Exception e) {
            out.print(e.getMessage());
        }
        
    }
}
