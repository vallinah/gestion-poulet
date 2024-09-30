package controller;

import java.io.IOException;
import java.util.List;

import dao.ChargeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCharge extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String action = request.getParameter("action");
                ChargeDAO dao = new ChargeDAO();
                try {
                    if (action != null && !action.isEmpty()) {
                        switch (action) {
                            case "list":
                                List<Charge> charges = dao.getAll();
                                request.setAttribute("charges", charges);
                                break;
                            case "modifier":
                                int chargeId = Integer.parseInt(request.getParameter("chargeId"));
                                Charge charge = dao.getById(chargeId);
                                request.setAttribute("charge", charge);
                                break;
                            default:
                                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                                break;
                        }
                        request.getRequestDispatcher("insertcharge.jsp").forward(request, response); 
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
