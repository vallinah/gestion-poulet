package util;

import java.util.List;

import dao.PouletDAO;
public class Facture {
    private int idElevage;
    private double prixVenteKg;
    private double prixVenteTotal;
    private double depenseTotal;
    private double benefices;

     private PouletDAO pouletDAO;
        // Méthodes d'accès pour les attributs
        public double getPrixVenteTotal() {
            return prixVenteTotal;
        }
    
        public double getDepenseTotal() {
            return depenseTotal;
        }
    
        public double getBenefices() {
            return benefices;
        }

        public Facture(int idElevage, double prixVenteKg) {
            this.idElevage = idElevage;
            this.prixVenteKg = prixVenteKg;
            this.pouletDAO = new PouletDAO();
        }
    private void calculateTotals() {
        this.prixVenteTotal = calculerPrixVenteTotal();
        this.depenseTotal = calculerDepenseTotal();
        this.benefices = this.prixVenteTotal - this.depenseTotal;
    }

    // Méthode pour calculer le prix de vente total
    private double calculerPrixVenteTotal() {
        double total = 0.0;
        // Récupérer tous les poulets associés à l'élevage
        List<Poulet> poulets = pouletDAO.getPouletsByElevage(idElevage);
        for (Poulet poulet : poulets) {
            total += poulet.getPoidsFinal() * prixVenteKg; // calculer le prix de vente
        }
        return total;
    }

    // Méthode pour calculer les dépenses totales
    private double calculerDepenseTotal() {
        // Ici, tu peux implémenter la logique pour calculer les dépenses totales
        // En fonction des dépenses associées à l'élevage
        double total = 0.0;
        // Implémentation ici pour récupérer et additionner les dépenses...
        return total;
    }
}
