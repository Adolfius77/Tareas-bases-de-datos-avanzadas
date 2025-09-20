/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionDB;
import interfacez.IProblemaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Problema;

/**
 *
 * @author USER
 */
public class ProblemaDAO implements IProblemaDAO{

    @Override
    public boolean insertar(Problema problema) {
        String sql = "INSERT INTO Problema (fch_ini, fch_fin, estado, idCliente) VALUES (? , ?, ?, ?)";
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, problema.getFchIni());
            ps.setDate(2, problema.getFchFin());
            ps.setString(3, problema.getEstado());
            ps.setInt(4, problema.getIdCliente());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("error al insertar problema: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Problema> obtenerTodos() {
        String sql = "SELECT * FROM Problema ";
        List<Problema> lista = new ArrayList<>();
        
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Problema problema = new Problema();
                problema.setIdProblema(rs.getInt("idProblema"));
                problema.setFchIni(rs.getDate("fch_ini"));
                problema.setFchFin(rs.getDate("fch_fin"));
                problema.setEstado(rs.getString("estado"));
                problema.setIdCliente(rs.getInt("idCliente"));
                lista.add(problema);
            }
        } catch (SQLException e) {
            System.err.println("error al obtener todos lo problemas: " + e.getMessage());
        }
        return  lista;
    }



    @Override
    public boolean actualizar(Problema problema) {
        String sql = "UPDATE Problema SET fch_ini  = ?, fch_fin = ?, estado = ?, idCliente = ? WHERE idProblema = ?";
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDate(1, problema.getFchIni());
            ps.setDate(2, problema.getFchFin());
            ps.setString(3, problema.getEstado());
            ps.setInt(4, problema.getIdCliente());
            ps.setInt(5, problema.getIdProblema());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("error al actualizar el problema: "+ e.getMessage());
            return false;
        }
  
    }

    @Override
    public boolean eliminar(int idProblema) {
        String sql = "DELETE FROM Problema WHERE idProblema = ?";
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProblema);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Errror al eliminar el problema: " + e.getMessage());
            return false;
        }
    }
    @Override
    public Problema obtenerPorId(int idProblema) {
        String sql = "SELECT * FROM Problema WHERE idProblema = ?";
        Problema problema = null;

        try(Connection conn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idProblema);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                problema = new Problema();
                problema.setIdProblema(rs.getInt("idProblema"));
                problema.setFchIni(rs.getDate("fch_ini"));
                problema.setFchFin(rs.getDate("fch_fin"));
                problema.setEstado(rs.getString("estado"));
                problema.setIdCliente(rs.getInt("idCliente"));
            }

        } catch (SQLException e) {
            System.out.println("error al obtener problema: " + e.getMessage());
        }
        return problema;
    }
    
}
