package dao;

import connexion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.*;

public class AnalytiqueDesCoutsDAO {

    private Connexion connexion = new Connexion();

    // Methode pour inserer un analytique des couts
    public void insert(AnalytiqueDesCouts analytiqueDesCouts) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO analytique_des_couts(nom) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, analytiqueDesCouts.getNom());

            stmt.executeUpdate();
            System.out.println("Analytique des couts insere avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Methode pour mettre à jour un analytique des couts existant
    public void update(AnalytiqueDesCouts analytiqueDesCouts) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE analytique_des_couts SET nom=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, analytiqueDesCouts.getNom());
            stmt.setInt(2, analytiqueDesCouts.getId());

            stmt.executeUpdate();
            System.out.println("Analytique des couts mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Methode pour supprimer un analytique des couts par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM analytique_des_couts WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Analytique des couts supprime avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Methode pour recuperer tous les analytiques des couts
    public List<AnalytiqueDesCouts> getAll() {
        List<AnalytiqueDesCouts> analytiquesDesCouts = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM analytique_des_couts";
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

    // Methode pour recuperer un analytique des couts par ID
    public AnalytiqueDesCouts getById(int id) {
        AnalytiqueDesCouts analytiqueDesCouts = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM analytique_des_couts WHERE id=?";
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

