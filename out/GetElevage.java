package controller;

import java.io.IOException;
import java.util.List;

import dao.AnalytiqueDesCoutsDAO;
import dao.ChargeAnalytiqueDAO;
import dao.ChargeDAO;
import dao.ElevageDAO;
import dao.TypeChargeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.AnalytiqueDesCouts;
import util.Charge;
import util.ChargeAnalytique;
import util.Elevage;
import util.TypeCharge;

public class GetElevage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ElevageDAO dao = new ElevageDAO();

        try {
            List<Elevage> elevages = dao.getAll();
            request.setAttribute("elevages", elevages);
            request.getRequestDispatcher("insertPoulet.jsp").forward(request, response);

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
