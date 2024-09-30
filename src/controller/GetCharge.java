package controller;

import java.io.IOException;
import java.util.List;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.*;

public class GetCharge extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ChargeDAO dao = new ChargeDAO();

        try {
            if (action != null && !action.isEmpty()) {
                switch (action) {
                    case "insert":
                        List<ChargeAnalytique> chargeAnalytique = new ChargeAnalytiqueDAO().getAll();
                        List<AnalytiqueDesCouts> analytiqueDesCouts = new AnalytiqueDesCoutsDAO().getAll();
                        List<TypeCharge> typeCharge = new TypeChargeDAO().getAll();
                        request.setAttribute("chargeAnalytique", chargeAnalytique);
                        request.setAttribute("analytiqueDesCouts", analytiqueDesCouts);
                        request.setAttribute("typeCharge", typeCharge);
                        String path = "pages/forms/insertCharge.jsp";
                        request.getRequestDispatcher(path).forward(request, response);

                        break;
                    case "modifier":
                        int chargeId = Integer.parseInt(request.getParameter("chargeId"));
                        Charge charge = dao.getById(chargeId);
                        request.setAttribute("charge", charge);
                        String paths = "/pages/forms/insertCharge.jsp";
                        request.getRequestDispatcher(paths).forward(request, response);

                        break;
                    case "list":
                        List<Charge> charges = new ChargeDAO().getAll();
                        ElevageService elevage = new ElevageService();
                        Poulet poulet = new Poulet();
                        double chiffre = poulet.getChiffreAffaire(Integer.parseInt(request.getParameter("idElevage")));
                        double variable = elevage.calculMargeCouteVariable(Integer.parseInt(request.getParameter("idElevage")));
                        double fixe = elevage.calculMargeCouteFixe(Integer.parseInt(request.getParameter("idElevage")));
                        double marge = elevage.calculMargeGlobal(Integer.parseInt(request.getParameter("idElevage")));
                        request.setAttribute("charges", charges);
                        request.setAttribute("chiffre", chiffre);
                        request.setAttribute("variable", variable);
                        request.setAttribute("fixe", fixe);
                        request.setAttribute("marge", marge);
                        request.getRequestDispatcher("/pages/tables/basic-table.jsp").forward(request, response);
                        break;
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        break;
                }

            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
