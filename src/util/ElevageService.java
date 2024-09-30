package util;

import dao.*;
import java.util.List;

public class ElevageService {

    private PouletDAO pouletDAO = new PouletDAO();
    private DepenseDAO depenseDAO = new DepenseDAO();
    private ChargeDAO chargeDAO = new ChargeDAO();

    // Fonction pour calculer les dépenses par vitamines
    public double calculerDepenseParVitamines(int idElevage) {
        List<Depense> depenses = depenseDAO.getDepensesByChargeType(idElevage, "vitamines");
        return calculerDepenseTotal(depenses);
    }

    // Fonction pour calculer les dépenses par aliments
    public double calculerDepenseParAliments(int idElevage) {
        List<Depense> depenses = depenseDAO.getDepensesByChargeType(idElevage, "aliments");
        return calculerDepenseTotal(depenses);
    }

    // Fonction pour calculer les dépenses par poulet (qte * prix unitaire)
    public double calculerDepenseParPoulet(int idElevage) {
        List<Depense> depenses = depenseDAO.getDepensesByElevage(idElevage);
        int nbPoulets = getNombreTotalPoulet(idElevage);
        return calculerDepenseTotal(depenses) / nbPoulets;
    }

    // Fonction pour calculer le coût par poulet
    public double calculerCoutParPoulet(int idElevage) {
        return calculerDepenseParPoulet(idElevage);
    }

    // Fonction pour calculer le poids final d'un poulet
    public double calculerPoidsFinal(Poulet poulet) {
        return poulet.getPoidsInitial() + poulet.getPoidsGrow();
    }

    // Fonction pour calculer le prix de vente d'un poulet
    public double calculerPrixVente(Poulet poulet, double prixVenteKg) {
        return calculerPoidsFinal(poulet) * prixVenteKg;
    }

    // Fonction pour calculer le prix de vente total d'un élevage
    public double calculerPrixVenteTotal(int idElevage, double prixVenteKg) {
        List<Poulet> poulets = pouletDAO.getPouletsByElevage(idElevage);
        double prixVenteTotal = 0;
        for (Poulet poulet : poulets) {
            prixVenteTotal += calculerPrixVente(poulet, prixVenteKg);
        }
        return prixVenteTotal;
    }

    // Fonction pour calculer les dépenses totales pour un élevage
    public double calculerDepenseTotal(int idElevage) {
        List<Depense> depenses = depenseDAO.getDepensesByElevage(idElevage);
        return calculerDepenseTotal(depenses);
    }

    // Fonction pour calculer les bénéfices
    public double calculerBenefices(int idElevage, double prixVenteKg) {
        double prixVenteTotal = calculerPrixVenteTotal(idElevage, prixVenteKg);
        double depenseTotal = calculerDepenseTotal(idElevage);
        return prixVenteTotal - depenseTotal;
    }

    // Méthode utilitaire pour calculer le total des dépenses à partir d'une liste
    // de dépenses
    private double calculerDepenseTotal(List<Depense> depenses) {
        double total = 0;
        for (Depense depense : depenses) {
            Charge charge = chargeDAO.getById(depense.getIdCharge());
            total += depense.getQuantite() * charge.getPrixUnitaire();
        }
        return total;
    }

    // Fonction pour obtenir le nombre total de poulets dans un cycle d'élevage
    public int getNombreTotalPoulet(int idElevage) {
        return pouletDAO.getNbPoulet(idElevage);
    }

    // Fonction pour générer une facture
    public Facture getCompteFacture(int idElevage, double prixVenteKg) {
        Facture fact = new Facture(idElevage, prixVenteKg);

        return fact;
    }

    public double calculMargeGlobal(int idElevage) {
        double margeGlobal = 0;
        Poulet p = new Poulet();
        double coutFixe = depenseDAO.getTotalAnalytiqueDesCoûts(1, "fixe");
        double coutVariable = depenseDAO.getTotalAnalytiqueDesCoûts(1, "variable");
        double chiffreAffaire = p.getChiffreAffaire();
        margeGlobal = chiffreAffaire - (coutFixe + coutVariable);
        return margeGlobal;
    }

    public double calculMargeCouteFixe(int idElevage) {
        double mcf = 0;
        Poulet p = new Poulet();
        double coutFixe = depenseDAO.getTotalAnalytiqueDesCoûts(1, "fixe");
        double chiffreAffaire = p.getChiffreAffaire();
        mcf = chiffreAffaire - coutFixe;
        return mcf;
    }

    public double calculMargeCouteVariable(int idElevage) {
        double mcv = 0;
        Poulet p = new Poulet();
        double coutVariable = depenseDAO.getTotalAnalytiqueDesCoûts(1, "variable");
        double chiffreAffaire = p.getChiffreAffaire();
        mcv = chiffreAffaire - coutVariable;
        return mcv;
    }
}