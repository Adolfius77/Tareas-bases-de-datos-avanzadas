/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionDB;
import interfacez.IActivistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Activista;

/**
 *
 * @author USER
 */
public class ActivistaDAO implements IActivistaDAO{

    @Override
    public boolean insertar(Activista activista) {
        String sql = "INSERT INTO Activista (nombre, telefono, fchIngreso) VALUES(?,?,?)";
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getTelefono());
            ps.setDate(3, activista.getFchIngreso());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("error al insertar el activista: " + e.getMessage());
            return false;
            
        }
    }

    @Override
    public Activista obtenerPorId(int idActivista) {
        String sql = "SELECT * FROM Activista WHERE idActivista = ?";
        Activista activista = null;
        
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idActivista);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                activista = new Activista();
                activista.setIdActivista(rs.getInt("idActivista"));
                activista.setNombre(rs.getString("nombre"));
                activista.setTelefono(rs.getString("telefono"));
                activista.setFchIngreso(rs.getDate("fchIngreso"));
            }
        } catch (SQLException e) {
            System.err.println("error al obtener por id: " + e.getMessage());
        }
        return activista;
    }

    @Override
    public List<Activista> obtenerTodos() {
        String sql = "SELECT * FROM Activista";
        List<Activista> lista = new ArrayList<>();
        
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Activista activista = new Activista();
                activista.setIdActivista(rs.getInt("idActivista"));
                activista.setNombre(rs.getString("nombre"));
                activista.setTelefono(rs.getString("telefono"));
                activista.setFchIngreso(rs.getDate("fchIngreso"));
                lista.add(activista);
            }
        } catch (SQLException e) {
            System.err.println("error al obtener todos los activistas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(Activista activista) {
        String sql = "UPDATE Activista SET nombre = ?, telefono = ?, fchIngreso = ? WHERE idActivista = ?";
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getTelefono());
            ps.setDate(3, activista.getFchIngreso());
            ps.setInt(4, activista.getIdActivista());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("error al actualizar al activista: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idActista) {
        String sql = "DELETE FROM Activista WHERE idActivista = ?";
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idActista);
            
            return  ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("error al eliminar al activista: " + e.getMessage());
        }   return false;
    }
    
}
