package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class TraitemenetPouler extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Integer sessionClientId = (Integer) session.getAttribute("adminId");
    
            if (sessionClientId == null) {
                response.sendRedirect("login.jsp"); // Redirige vers la page de connexion
                return;
            }
    
            Client clientId = Client.trouverClientParId(Integer.parseInt(request.getParameter("clientId")));
            clientId.supprimerClient();
            response.sendRedirect("getClient?action=list"); // Redirige vers la page des clients
        } catch (Exception e) {
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        try {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String telephone = request.getParameter("numero_telephone");
            String motDePasse = request.getParameter("mot_de_passe");
            String adresse = request.getParameter("adresse");
            
            // // Création de l'objet Client avec l'URL de l'image
            Client client = new Client(0, nom, prenom, email, motDePasse, adresse, telephone, image);
    
            // Vérification de l'action à effectuer
            if (request.getParameter("clientId") != null) {
                client.setClientId(Integer.parseInt((String) request.getParameter("clientId")));
                client.mettreAJourClient();
            } else {
                client.ajouterClient();
            }
            response.sendRedirect("getClient?action=list");
    
           // Redirection vers la page des clients après traitement
        } catch (Exception e) {
            out.print(e.getMessage());
        }
        
    }

}
