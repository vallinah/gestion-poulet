package util;

public class Charge {

    private int id;
    private String nom;
    private double prixUnitaire;
    private String uniteOeuvre;
    private TypeCharge idTypeCharge;
    private ChargeAnalytique idChargeAnalytique;
    private AnalytiqueDesCouts idAnalytiqueCout;
    private double pourcentageDemarrage;
    private double pourcentageTransition;
    private double pourcentageFinition;

    // Constructeur par défaut
    public Charge() {
    }

    // Constructeur avec paramètres
    public Charge(int id, String nom, double prixUnitaire, String uniteOeuvre, TypeCharge idTypeCharge, 
    ChargeAnalytique idChargeAnalytique, AnalytiqueDesCouts idAnalytiqueCout, double pourcentageDemarrage, 
                  double pourcentageTransition, double pourcentageFinition) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.uniteOeuvre = uniteOeuvre;
        this.idTypeCharge = idTypeCharge;
        this.idChargeAnalytique = idChargeAnalytique;
        this.idAnalytiqueCout = idAnalytiqueCout;
        this.pourcentageDemarrage = pourcentageDemarrage;
        this.pourcentageTransition = pourcentageTransition;
        this.pourcentageFinition = pourcentageFinition;
    }

    @Override
public String toString() {
    return "Charge{" +
            "id=" + id +
            ", nom='" + nom + '\'' +
            ", prixUnitaire=" + prixUnitaire +
            ", uniteOeuvre='" + uniteOeuvre + '\'' +
            ", idTypeCharge=" + (idTypeCharge != null ? idTypeCharge.getNom() : "null") +
            ", idChargeAnalytique=" + (idChargeAnalytique != null ? idChargeAnalytique.getNom() : "null") +
            ", idAnalytiqueCout=" + (idAnalytiqueCout != null ? idAnalytiqueCout.getNom() : "null") +
            ", pourcentageDemarrage=" + pourcentageDemarrage +
            ", pourcentageTransition=" + pourcentageTransition +
            ", pourcentageFinition=" + pourcentageFinition +
            '}';
}


    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getUniteOeuvre() {
        return uniteOeuvre;
    }

    public void setUniteOeuvre(String uniteOeuvre) {
        this.uniteOeuvre = uniteOeuvre;
    }


    public double getPourcentageDemarrage() {
        return pourcentageDemarrage;
    }

    public void setPourcentageDemarrage(double pourcentageDemarrage) {
        this.pourcentageDemarrage = pourcentageDemarrage;
    }

    public double getPourcentageTransition() {
        return pourcentageTransition;
    }

    public void setPourcentageTransition(double pourcentageTransition) {
        this.pourcentageTransition = pourcentageTransition;
    }

    public double getPourcentageFinition() {
        return pourcentageFinition;
    }

    public void setPourcentageFinition(double pourcentageFinition) {
        this.pourcentageFinition = pourcentageFinition;
    }

    public TypeCharge getIdTypeCharge() {
        return idTypeCharge;
    }

    public void setIdTypeCharge(TypeCharge idTypeCharge) {
        this.idTypeCharge = idTypeCharge;
    }

    public ChargeAnalytique getIdChargeAnalytique() {
        return idChargeAnalytique;
    }

    public void setIdChargeAnalytique(ChargeAnalytique idChargeAnalytique) {
        this.idChargeAnalytique = idChargeAnalytique;
    }

    public AnalytiqueDesCouts getIdAnalytiqueCout() {
        return idAnalytiqueCout;
    }

    public void setIdAnalytiqueCout(AnalytiqueDesCouts idAnalytiqueCout) {
        this.idAnalytiqueCout = idAnalytiqueCout;
    }

}

