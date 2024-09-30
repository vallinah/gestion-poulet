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
                        request.getRequestDispatcher("insertcharge.jsp").forward(request, response);
                        break;
                    case "modifier":
                        int chargeId = Integer.parseInt(request.getParameter("chargeId"));
                        Charge charge = dao.getById(chargeId);
                        request.setAttribute("charge", charge);
                        request.getRequestDispatcher("insertcharge.jsp").forward(request, response);
                        break;
                    case "list":
                        List<Charge> charges = new ChargeDAO().getAll();
                        request.setAttribute("charges", charges);
                        request.getRequestDispatcher("basic-table.jsp").forward(request, response);
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
