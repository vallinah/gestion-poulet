package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.*;
import util.*;


public class DepenseDAO {

    private Connexion connexion = new Connexion();

    // Méthode pour insérer une nouvelle dépense
    public void insert(Depense depense) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO dépense(id_charge, quantité) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, depense.getIdCharge());
            stmt.setDouble(2, depense.getQuantite());

            stmt.executeUpdate();
            System.out.println("Dépense insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour une dépense existante
    public void update(Depense depense) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE dépense SET id_charge=?, quantité=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, depense.getIdCharge());
            stmt.setDouble(2, depense.getQuantite());
            stmt.setInt(3, depense.getId());

            stmt.executeUpdate();
            System.out.println("Dépense mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour supprimer une dépense par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM dépense WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Dépense supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour récupérer toutes les dépenses
    public List<Depense> getAll() {
        List<Depense> depenses = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM dépense";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Depense depense = new Depense();
                depense.setId(rs.getInt("id"));
                depense.setIdCharge(rs.getInt("id_charge"));
                depense.setQuantite(rs.getDouble("quantité"));

                depenses.add(depense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return depenses;
    }

    // Méthode pour récupérer une dépense par ID
    public Depense getById(int id) {
        Depense depense = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM dépense WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                depense = new Depense();
                depense.setId(rs.getInt("id"));
                depense.setIdCharge(rs.getInt("id_charge"));
                depense.setQuantite(rs.getDouble("quantité"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return depense;
    }
}

