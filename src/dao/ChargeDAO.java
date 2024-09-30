package dao;

import connexion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.*;

public class ChargeDAO {

    private Connexion connexion = new Connexion();

    // Méthode pour insérer une nouvelle charge
    public void insert(Charge charge) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO charge(nom, prix_unitaire, unité_oeuvre, id_type_charge, id_charge_analytique, id_analytique_coût, pourcentage_démarrage, pourcentage_transition, pourcentage_finition) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.setDouble(2, charge.getPrixUnitaire());
            stmt.setString(3, charge.getUniteOeuvre());
            stmt.setInt(4, charge.getIdTypeCharge().getId());
            stmt.setInt(5, charge.getIdChargeAnalytique().getId());
            stmt.setInt(6, charge.getIdAnalytiqueCout().getId());
            stmt.setDouble(7, charge.getPourcentageDemarrage());
            stmt.setDouble(8, charge.getPourcentageTransition());
            stmt.setDouble(9, charge.getPourcentageFinition());

            stmt.executeUpdate();
            System.out.println("Charge insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour une charge existante
    public void update(Charge charge) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE charge SET nom=?, prix_unitaire=?, unité_oeuvre=?, id_type_charge=?, id_charge_analytique=?, id_analytique_coût=?, pourcentage_démarrage=?, pourcentage_transition=?, pourcentage_finition=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.setDouble(2, charge.getPrixUnitaire());
            stmt.setString(3, charge.getUniteOeuvre());
            stmt.setInt(4, charge.getIdTypeCharge().getId());
            stmt.setInt(5, charge.getIdChargeAnalytique().getId());
            stmt.setInt(6, charge.getIdAnalytiqueCout().getId());
            stmt.setDouble(7, charge.getPourcentageDemarrage());
            stmt.setDouble(8, charge.getPourcentageTransition());
            stmt.setDouble(9, charge.getPourcentageFinition());
            stmt.setInt(10, charge.getId());

            stmt.executeUpdate();
            System.out.println("Charge mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour supprimer une charge par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM charge WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Charge supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour récupérer toutes les charges
    public List<Charge> getAll() {
        List<Charge> charges = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Charge charge = new Charge();
                charge.setId(rs.getInt("id"));
                charge.setNom(rs.getString("nom"));
                charge.setPrixUnitaire(rs.getDouble("prix_unitaire"));
                charge.setUniteOeuvre(rs.getString("unité_oeuvre"));
                charge.setIdTypeCharge(new TypeChargeDAO().getById(rs.getInt("id_type_charge")));
                charge.setIdChargeAnalytique(new ChargeAnalytiqueDAO().getById(rs.getInt("id_charge_analytique")) );
                charge.setIdAnalytiqueCout(new AnalytiqueDesCoutsDAO().getById( rs.getInt("id_analytique_coût")));
                charge.setPourcentageDemarrage(rs.getDouble("pourcentage_démarrage"));
                charge.setPourcentageTransition(rs.getDouble("pourcentage_transition"));
                charge.setPourcentageFinition(rs.getDouble("pourcentage_finition"));

                charges.add(charge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charges;
    }

    // Méthode pour récupérer une charge par ID
    public Charge getById(int id) {
        Charge charge = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                charge = new Charge();
                charge.setId(rs.getInt("id"));
                charge.setNom(rs.getString("nom"));
                charge.setPrixUnitaire(rs.getDouble("prix_unitaire"));
                charge.setUniteOeuvre(rs.getString("unité_oeuvre"));
                charge.setIdTypeCharge(new TypeChargeDAO().getById(rs.getInt("id_type_charge")));
                charge.setIdChargeAnalytique(new ChargeAnalytiqueDAO().getById(rs.getInt("id_charge_analytique")) );
                charge.setIdAnalytiqueCout(new AnalytiqueDesCoutsDAO().getById( rs.getInt("id_analytique_coût")));
                charge.setPourcentageDemarrage(rs.getDouble("pourcentage_démarrage"));
                charge.setPourcentageTransition(rs.getDouble("pourcentage_transition"));
                charge.setPourcentageFinition(rs.getDouble("pourcentage_finition"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charge;
    }
}

