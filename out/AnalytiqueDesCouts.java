package util;

public class AnalytiqueDesCouts {

    private int id;
    private String nom;

    // Constructeur par défaut
    public AnalytiqueDesCouts() {
    }

    // Constructeur avec paramètres
    public AnalytiqueDesCouts(int id, String nom) {
        this.id = id;
        this.nom = nom;
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

    // Méthode toString
    @Override
    public String toString() {
        return "AnalytiqueDesCouts{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}

