package util;

public class Poulet {

    private int id;
    private double poidsInitial;
    private double poidsFinal;
    private double poidsGrow;
    private double prixDeVente;
    private double cout;

    private int idElevage;

    // Constructeur par défaut
    public Poulet() {
    }

    // Constructeur avec paramètres
    public Poulet(int id, double poidsInitial, double poidsFinal, double poidsGrow, double prixDeVente, double cout,
            int idElevage) {
        this.id = id;
        this.poidsInitial = poidsInitial;
        this.poidsFinal = poidsFinal;
        this.poidsGrow = poidsGrow;
        this.prixDeVente = prixDeVente;
        this.cout = cout;
    }

    // Getters et Setters
    public int getIdElevage() {
        return idElevage;
    }

    public void setIdElevage(int id) {
        this.idElevage = id;
    }

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

    public double getPoidsFinal() {
        return poidsFinal;
    }

    public void setPoidsFinal(double poidsFinal) {
        this.poidsFinal = poidsFinal;
    }

    public double getPoidsGrow() {
        return poidsGrow;
    }

    public void setPoidsGrow(double poidsGrow) {
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

}
