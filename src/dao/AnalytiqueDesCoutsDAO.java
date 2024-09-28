package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.*;
import util.*;

public class AnalytiqueDesCoutsDAO {

    private Connexion connexion = new Connexion();

    // Méthode pour insérer un analytique des coûts
    public void insert(AnalytiqueDesCouts analytiqueDesCouts) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO analytique_des_coûts(nom) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, analytiqueDesCouts.getNom());

            stmt.executeUpdate();
            System.out.println("Analytique des coûts inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour un analytique des coûts existant
    public void update(AnalytiqueDesCouts analytiqueDesCouts) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE analytique_des_coûts SET nom=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, analytiqueDesCouts.getNom());
            stmt.setInt(2, analytiqueDesCouts.getId());

            stmt.executeUpdate();
            System.out.println("Analytique des coûts mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour supprimer un analytique des coûts par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM analytique_des_coûts WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Analytique des coûts supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour récupérer tous les analytiques des coûts
    public List<AnalytiqueDesCouts> getAll() {
        List<AnalytiqueDesCouts> analytiquesDesCouts = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM analytique_des_coûts";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AnalytiqueDesCouts analytiqueDesCouts = new AnalytiqueDesCouts();
                analytiqueDesCouts.setId(rs.getInt("id"));
                analytiqueDesCouts.setNom(rs.getString("nom"));

                analytiquesDesCouts.add(analytiqueDesCouts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return analytiquesDesCouts;
    }

    // Méthode pour récupérer un analytique des coûts par ID
    public AnalytiqueDesCouts getById(int id) {
        AnalytiqueDesCouts analytiqueDesCouts = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM analytique_des_coûts WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                analytiqueDesCouts = new AnalytiqueDesCouts();
                analytiqueDesCouts.setId(rs.getInt("id"));
                analytiqueDesCouts.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return analytiqueDesCouts;
    }
}

