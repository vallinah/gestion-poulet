package util;

import java.util.List;

import dao.PouletDAO;

public class Poulet {
    private int id;
    private double poidsInitial;
    private Double poidsFinal; // Poids final peut être nul, donc `Double` au lieu de `double`
    private Double poidsGrow; // Idem pour le poids de croissance
    private double prixDeVente;
    private double cout;
    private int idElevage; // Référence à l'élevage (clé étrangère)

    // Constructeur par défaut
    public Poulet() {
    }

    // Constructeur avec paramètres
    public Poulet(int id, double poidsInitial, Double poidsFinal, Double poidsGrow, double prixDeVente, double cout,
            int idElevage) {
        this.id = id;
        this.poidsInitial = poidsInitial;
        this.poidsFinal = poidsFinal;
        this.poidsGrow = poidsGrow;
        this.prixDeVente = prixDeVente;
        this.cout = cout;
        this.idElevage = idElevage;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoidsInitial() {
        return poidsInitial;
    }

    public void setPoidsInitial(double poidsInitial) {
        this.poidsInitial = poidsInitial;
    }

    public Double getPoidsFinal() {
        return poidsFinal;
    }

    public void setPoidsFinal(Double poidsFinal) {
        this.poidsFinal = poidsFinal;
    }

    public Double getPoidsGrow() {
        return poidsGrow;
    }

    public void setPoidsGrow(Double poidsGrow) {
        this.poidsGrow = poidsGrow;
    }

    public double getPrixDeVente() {
        return prixDeVente;
    }

    public void setPrixDeVente(double prixDeVente) {
        this.prixDeVente = prixDeVente;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public int getIdElevage() {
        return idElevage;
    }

    public void setIdElevage(int idElevage) {
        this.idElevage = idElevage;
    }

    public double getChiffreAffaire() {
        PouletDAO pd = new PouletDAO();
        double cf = 0;
        List<Poulet> poultes = pd.getAll();
        for (Poulet poulet : poultes) {
            cf += poulet.getPrixDeVente();
        }
        return cf;
    }
}
