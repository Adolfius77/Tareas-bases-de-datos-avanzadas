/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Config.ConexionDB;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import interfacez.IClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author USER
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public boolean insertar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nombre, direccion,telefonos) VALUES(?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Cliente obtenerPorId(int idCliente) {
        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
        Cliente cliente = null;

        try (Connection con = ConexionDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonos(rs.getString("telefonos"));

            }
        } catch (SQLException e) {
            System.err.println("error al obtener el cliente por id" + e.getMessage());

        }
        return cliente;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonos(rs.getString("telefonos"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("error al obtener todos los clientes: " + e.getMessage());

        }
        return lista;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET nombre = ?, direccion = ?, telefonos = ? WHERE idCliente = ? ";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareCall(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());
            ps.setInt(4, cliente.getIdCliente());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("error al actualizar al cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("error al eliminar al cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Cliente> obtenerTodosPorFiltro(String filtro) {
        String sql = "SELECT idCliente, nombre, direccion, telefonos  FROM Cliente WHERE nombre LIKE ? LIMIT 100";
        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonos(rs.getString("telefonos"));
                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener clientes por filtro: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public List<Cliente> obtenerTodosPorFiltroModal(String filtro) {
        String sql = "SELECT idCliente, nombre, telefonos  FROM Cliente WHERE nombre LIKE ? OR telefonos LIKE ? LIMIT 100";
        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + filtro + "%");
            ps.setString(2, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefonos(rs.getString("telefonos"));
                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener clientes por filtro: " + e.getMessage());
        }

        return lista;
    }
}
