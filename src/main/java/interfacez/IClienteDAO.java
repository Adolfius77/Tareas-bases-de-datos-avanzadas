/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacez;

import java.util.List;
import model.Cliente;

/**
 *
 * @author USER
 */
public interface IClienteDAO {
    boolean insertar(Cliente cliente);
    Cliente obtenerPorId(int idCliente);
    List<Cliente> obtenerTodos();
    boolean actualizar(Cliente cliente);
    boolean eliminar(int idCliente);
    List<Cliente> obtenerTodosPorFiltro(String filtro);
    List<Cliente> obtenerTodosPorFiltroModal(String filtro);
}
