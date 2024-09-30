package util;

public class Depense {

    private int id;
    private int idCharge;
    private double quantite;

    // Constructeur par défaut
    public Depense() {
    }

    // Constructeur avec paramètres
    public Depense(int id, int idCharge, double quantite) {
        this.id = id;
        this.idCharge = idCharge;
        this.quantite = quantite;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(int idCharge) {
        this.idCharge = idCharge;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
}

