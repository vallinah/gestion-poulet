package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.*;
import util.*;
import java.time.LocalDate;


public class ElevageDAO {

    private Connexion connexion = new Connexion();

    // Méthode pour insérer un nouvel élevage
    public void insert(Elevage elevage) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO elevage(date_debut, duree_cycle, nb_poulets) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(elevage.getDateDebut()));  // Conversion de LocalDate à SQL Date
            stmt.setInt(2, elevage.getDureeCycle());

            stmt.executeUpdate();
            System.out.println("Élevage inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour un élevage existant
    public void update(Elevage elevage) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE elevage SET date_debut=?, duree_cycle=?, nb_poulets=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(elevage.getDateDebut()));  // Conversion de LocalDate à SQL Date
            stmt.setInt(2, elevage.getDureeCycle());
            stmt.setInt(3, elevage.getId());

            stmt.executeUpdate();
            System.out.println("Élevage mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour supprimer un élevage par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM elevage WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Élevage supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour récupérer tous les élevages
    public List<Elevage> getAll() {
        List<Elevage> elevages = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM elevage";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Elevage elevage = new Elevage();
                elevage.setId(rs.getInt("id"));
                elevage.setDateDebut(rs.getDate("date_debut").toLocalDate());  // Conversion de SQL Date à LocalDate
                elevage.setDureeCycle(rs.getInt("duree_cycle"));

                elevages.add(elevage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return elevages;
    }

    // Méthode pour récupérer un élevage par ID
    public Elevage getById(int id) {
        Elevage elevage = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM elevage WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                elevage = new Elevage();
                elevage.setId(rs.getInt("id"));
                elevage.setDateDebut(rs.getDate("date_debut").toLocalDate());  // Conversion de SQL Date à LocalDate
                elevage.setDureeCycle(rs.getInt("duree_cycle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return elevage;
    }

    // Méthode pour calculer la date de fin d'un cycle d'élevage
    public Date getDateFinCycle(int idElevage) {
        Date dateFin = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT date_debut, duree_cycle FROM elevage WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Date dateDebut = rs.getDate("date_debut");
                int dureeCycle = rs.getInt("duree_cycle");
                // Calcul de la date de fin
                LocalDate localDateDebut = dateDebut.toLocalDate();
                LocalDate dateFinCycle = localDateDebut.plusDays(dureeCycle);  // Ajoute la durée du cycle en jours
                dateFin = Date.valueOf(dateFinCycle);  // Conversion de LocalDate à SQL Date
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return dateFin;
    }
}
