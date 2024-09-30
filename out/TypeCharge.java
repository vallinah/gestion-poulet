package util;

public class TypeCharge {

    private int id;
    private String nom;

    // Constructeur par défaut
    public TypeCharge() {
    }

    // Constructeur avec paramètres
    public TypeCharge(int id, String nom) {
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


}

