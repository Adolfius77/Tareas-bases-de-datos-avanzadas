/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionDB;
import interfacez.IProblemaActivistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Problema;
import model.ProblemaActivista;

/**
 *
 * @author USER
 */
public class ProblemaActivistaDAO implements IProblemaActivistaDAO {

    @Override
    public boolean insertar(ProblemaActivista relacion) {
        String sql = "INSERT INTO Problema_Activista (idProblema, idActivista) VALUES (?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, relacion.getIdProblema());
            ps.setInt(2, relacion.getIdActivista());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("error al insertar una relacion entre problema y activista" + e.getMessage());
            return false;
        }
    }

    @Override
    public List<ProblemaActivista> obtenerPorProblema(int idProblema) {
        String sql = "SELECT * FROM Problema_Activista WHERE idProblema = ?";
        List<ProblemaActivista> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProblema);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProblemaActivista relacion = new ProblemaActivista();
                relacion.setIdProblema(rs.getInt("idProblema"));
                relacion.setIdActivista(rs.getInt("idActivista"));
                lista.add(relacion);
            }

        } catch (SQLException e) {
            System.err.println("error al obetenr relaciones por problema: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<ProblemaActivista> obtenerPorActivista(int idActivista) {
        String sql = "SELECT * FROM Problema_Activista WHERE idActivista = ?";
        List<ProblemaActivista> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idActivista);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProblemaActivista relacion = new ProblemaActivista();
                relacion.setIdProblema(rs.getInt("idProblema"));
                relacion.setIdActivista(rs.getInt("idActivista"));
                lista.add(relacion);

            }
        } catch (SQLException e) {
            System.err.println("error al obtener relaciones por activista: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean eliminar(int idProblema, int idActivista) {
        String sql = "DELETE FROM Problema_Activista WHERE idProblema = ? AND idActivista = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProblema);
            ps.setInt(2, idActivista);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("errorr al eliminar la relacion entre problema y activista" + e.getMessage());
            return false;
        }
    }

    @Override
    public List<ProblemaActivista> obtenerTodos(DefaultTableModel modelo) {
        String sql = "SELECT * FROM Problema_Activista ";
        List<ProblemaActivista> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProblemaActivista problemaActivista = new ProblemaActivista();
                problemaActivista.setIdProblema(rs.getInt("idProblema"));
                problemaActivista.setIdActivista(rs.getInt("problemaActivista"));

                lista.add(problemaActivista);
            }
        } catch (SQLException e) {
            System.err.println("error al obtener todos lo problemas de los activistas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public List<ProblemaActivista> obtenerTodosPorFiltro(String filtro) {
    
        String sql = "SELECT pa.idProblema, pa.idActivista "
                + "FROM Problema_Activista pa "
                + "JOIN Problema p ON pa.idProblema = p.idProblema "
                + "JOIN Activista a ON pa.idActivista = a.idActivista "
                + "WHERE p.descripcion LIKE ? OR a.nombre LIKE ?";

        List<ProblemaActivista> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + filtro + "%");
            ps.setString(2, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProblemaActivista relacion = new ProblemaActivista();
                relacion.setIdProblema(rs.getInt("idProblema"));
                relacion.setIdActivista(rs.getInt("idActivista"));
                lista.add(relacion);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener asignaciones por filtro: " + e.getMessage());
        }
        return lista;
    }
}
