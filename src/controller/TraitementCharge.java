package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.AnalytiqueDesCoutsDAO;
import dao.ChargeAnalytiqueDAO;
import dao.ChargeDAO;
import dao.TypeChargeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.AnalytiqueDesCouts;
import util.Charge;
import util.ChargeAnalytique;
import util.TypeCharge;
import java.util.logging.Logger;

public class TraitementCharge extends HttpServlet {
    private static final Logger logger = Logger.getLogger(TraitementCharge.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

        } catch (Exception e) {
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String nom = request.getParameter("nom");
            double prix_unitaire = Double.parseDouble(request.getParameter("prix_unitaire"));
            String unite_oeuvre = request.getParameter("unite_oeuvre");
            TypeCharge typeCharge = new TypeChargeDAO().getById(Integer.parseInt(request.getParameter("id_type_charge")));
            ChargeAnalytique chargeAnalytique = new ChargeAnalytiqueDAO().getById(Integer.parseInt(request.getParameter("id_charge_analytique")));
            AnalytiqueDesCouts analytiqueDesCouts = new AnalytiqueDesCoutsDAO().getById(Integer.parseInt(request.getParameter("id_analytique_cout")));
            double pourcentage_demarrage = Double.parseDouble(request.getParameter("pourcentage_demarrage"));
            double pourcentage_transition = Double.parseDouble(request.getParameter("pourcentage_transition"));
            double pourcentage_finition = Double.parseDouble(request.getParameter("pourcentage_finition"));
            ChargeDAO dao = new ChargeDAO();



            Charge charge = new Charge(0, nom, prix_unitaire, unite_oeuvre, typeCharge, chargeAnalytique,
                    analytiqueDesCouts, pourcentage_demarrage, pourcentage_transition, pourcentage_finition);

            out.println(charge.toString());
            if (request.getParameter("chargeId") != null) {
                charge.setId(Integer.parseInt((String) request.getParameter("chargeId")));
                dao.update(charge);
            } else {
                dao.insert(charge);
            }
            logger.info(charge.toString());
            // request.getRequestDispatcher("insertCharge.jsp");

            // Redirection vers la page des clients après traitement
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
