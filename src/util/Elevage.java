package util;

import java.time.LocalDate;

public class Elevage {
    private int id;
    private LocalDate dateDebut;
    private int dureeCycle;

    // Constructeur par défaut
    public Elevage() {
    }

    // Constructeur avec paramètres
    public Elevage(int id, LocalDate dateDebut, int DureeCycle) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dureeCycle = DureeCycle;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDureeCycle() {
        return dureeCycle;
    }

    public void setDureeCycle(int DureeCycle) {
        this.dureeCycle = DureeCycle;
    }
}
