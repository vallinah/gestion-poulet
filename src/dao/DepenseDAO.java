package dao;

import connexion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.*;

public class DepenseDAO {

    private Connexion connexion = new Connexion();

    // Methode pour inserer une nouvelle depense
    public void insert(Depense depense) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO depense(id_charge, quantite) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, depense.getIdCharge());
            stmt.setDouble(2, depense.getQuantite());

            stmt.executeUpdate();
            System.out.println("Depense inseree avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Methode pour mettre à jour une depense existante
    public void update(Depense depense) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE depense SET id_charge=?, quantite=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, depense.getIdCharge());
            stmt.setDouble(2, depense.getQuantite());
            stmt.setInt(3, depense.getId());

            stmt.executeUpdate();
            System.out.println("Depense mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Methode pour supprimer une depense par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM depense WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Depense supprimee avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Methode pour recuperer toutes les depenses
    public List<Depense> getAll() {
        List<Depense> depenses = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM depense";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Depense depense = new Depense();
                depense.setId(rs.getInt("id"));
                depense.setIdCharge(rs.getInt("id_charge"));
                depense.setQuantite(rs.getDouble("quantite"));

                depenses.add(depense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return depenses;
    }

    // Methode pour recuperer une depense par ID
    public Depense getById(int id) {
        Depense depense = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM depense WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                depense = new Depense();
                depense.setId(rs.getInt("id"));
                depense.setIdCharge(rs.getInt("id_charge"));
                depense.setQuantite(rs.getDouble("quantite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return depense;
    }

    // Methode pour recuperer toutes les depenses d'un elevage
    public List<Depense> getDepensesByElevage(int idElevage) {
        List<Depense> depenses = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM depense d JOIN charge c ON d.id_charge = c.id WHERE c.id_elevage = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Depense depense = new Depense();
                depense.setId(rs.getInt("id"));
                depense.setIdCharge(rs.getInt("id_charge"));
                depense.setQuantite(rs.getDouble("quantite"));
                depenses.add(depense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return depenses;
    }

    // Methode pour recuperer les depenses d'un type specifique (ex. vitamines,
    // aliments)
    public List<Depense> getDepensesByChargeType(int idElevage, String typeCharge) {
        List<Depense> depenses = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM depense d JOIN charge c ON d.id_charge = c.id " +
                "JOIN type_charge t ON c.id_type_charge = t.id WHERE t.nom = ? AND c.id_elevage = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, typeCharge);
            stmt.setInt(2, idElevage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Depense depense = new Depense();
                depense.setId(rs.getInt("id"));
                depense.setIdCharge(rs.getInt("id_charge"));
                depense.setQuantite(rs.getDouble("quantite"));
                depenses.add(depense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return depenses;
    }

    public double getTotalAnalytiqueDesCouts(int idElevage, String analytiqueDesCouts) {
        double cout = 0;
        Connection conn = connexion.getConnection();
        String sql = "SELECT SUM(c.prix_unitaire*d.quantite) FROM depense d JOIN charge c ON d.id_charge = c.id " +
                "JOIN analytique_des_couts a_c ON c.id_analytique_cout = a_c.id WHERE a_c.nom = ? AND c.id_elevage = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, analytiqueDesCouts);
            stmt.setInt(2, idElevage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cout += rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return cout;
    }
}
