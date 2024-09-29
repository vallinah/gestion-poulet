package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.*;
import util.*;

public class PouletDAO {

    private Connexion connexion = new Connexion();

    // Méthode pour insérer un nouveau poulet
    public void insert(Poulet poulet) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO poulet(poids_initial, poids_final, poids_grow, prix_de_vente, cout, id_elevage) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, poulet.getPoidsInitial());
            stmt.setDouble(2, poulet.getPoidsFinal());
            stmt.setDouble(3, poulet.getPoidsGrow());
            stmt.setDouble(4, poulet.getPrixDeVente());
            stmt.setDouble(5, poulet.getCout());
            stmt.setInt(6, poulet.getIdElevage());  // Ajout de l'ID d'élevage

            stmt.executeUpdate();
            System.out.println("Poulet inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour un poulet existant
    public void update(Poulet poulet) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE poulet SET poids_initial=?, poids_final=?, poids_grow=?, prix_de_vente=?, cout=?, id_elevage=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, poulet.getPoidsInitial());
            stmt.setDouble(2, poulet.getPoidsFinal());
            stmt.setDouble(3, poulet.getPoidsGrow());
            stmt.setDouble(4, poulet.getPrixDeVente());
            stmt.setDouble(5, poulet.getCout());
            stmt.setInt(6, poulet.getIdElevage());  // Ajout de l'ID d'élevage
            stmt.setInt(7, poulet.getId());

            stmt.executeUpdate();
            System.out.println("Poulet mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour supprimer un poulet par ID
    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM poulet WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Poulet supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour récupérer tous les poulets
    public List<Poulet> getAll() {
        List<Poulet> poulets = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM poulet";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Poulet poulet = new Poulet();
                poulet.setId(rs.getInt("id"));
                poulet.setPoidsInitial(rs.getDouble("poids_initial"));
                poulet.setPoidsFinal(rs.getDouble("poids_final"));
                poulet.setPoidsGrow(rs.getDouble("poids_grow"));
                poulet.setPrixDeVente(rs.getDouble("prix_de_vente"));
                poulet.setCout(rs.getDouble("cout"));
                poulet.setIdElevage(rs.getInt("id_elevage"));  // Ajout de l'ID d'élevage

                poulets.add(poulet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return poulets;
    }

    // Méthode pour récupérer un poulet par ID
    public Poulet getById(int id) {
        Poulet poulet = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM poulet WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                poulet = new Poulet();
                poulet.setId(rs.getInt("id"));
                poulet.setPoidsInitial(rs.getDouble("poids_initial"));
                poulet.setPoidsFinal(rs.getDouble("poids_final"));
                poulet.setPoidsGrow(rs.getDouble("poids_grow"));
                poulet.setPrixDeVente(rs.getDouble("prix_de_vente"));
                poulet.setCout(rs.getDouble("cout"));
                poulet.setIdElevage(rs.getInt("id_elevage"));  // Ajout de l'ID d'élevage
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return poulet;
    }

    // Méthode pour récupérer le nombre total de poulets dans un cycle d'élevage donné
    public int getNbPoulet(int idElevage) {
        int nbPoulet = 0;
        Connection conn = connexion.getConnection();
        String sql = "SELECT COUNT(*) FROM poulet WHERE id_elevage=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nbPoulet = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return nbPoulet;
    }
    public List<Poulet> getPouletsByElevage(int idElevage) {
        List<Poulet> poulets = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM poulet WHERE id_elevage = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Poulet poulet = new Poulet();
                poulet.setId(rs.getInt("id"));
                poulet.setPoidsInitial(rs.getDouble("poids_initial"));
                poulet.setPoidsFinal(rs.getDouble("poids_final"));
                poulet.setPoidsGrow(rs.getDouble("poids_grow"));
                poulet.setPrixDeVente(rs.getDouble("prix_de_vente"));
                poulet.setCout(rs.getDouble("cout"));
                poulet.setIdElevage(idElevage); // Assurez-vous que la classe Poulet a un attribut idElevage

                poulets.add(poulet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return poulets;
    }
}
