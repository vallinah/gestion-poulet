package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.*;
import util.*;

public class ChargeAnalytiqueDAO {

    private Connexion connexion = new Connexion();

    // Méthode pour insérer un nouveau charge analytique
    public void insert(ChargeAnalytique chargeAnalytique) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO charge_analytique(nom) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chargeAnalytique.getNom());

            stmt.executeUpdate();
            System.out.println("Charge analytique inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour un charge analytique existant
    public void update(ChargeAnalytique chargeAnalytique) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE charge_analytique SET nom=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chargeAnalytique.getNom());
            stmt.setInt(2, chargeAnalytique.getId());

            stmt.executeUpdate();
            System.out.println("Charge analytique mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour supprimer un charge analytique par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM charge_analytique WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Charge analytique supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour récupérer tous les charges analytiques
    public List<ChargeAnalytique> getAll() {
        List<ChargeAnalytique> chargesAnalytiques = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge_analytique";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ChargeAnalytique chargeAnalytique = new ChargeAnalytique();
                chargeAnalytique.setId(rs.getInt("id"));
                chargeAnalytique.setNom(rs.getString("nom"));

                chargesAnalytiques.add(chargeAnalytique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return chargesAnalytiques;
    }

    // Méthode pour récupérer un charge analytique par ID
    public ChargeAnalytique getById(int id) {
        ChargeAnalytique chargeAnalytique = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge_analytique WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                chargeAnalytique = new ChargeAnalytique();
                chargeAnalytique.setId(rs.getInt("id"));
                chargeAnalytique.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return chargeAnalytique;
    }
}
