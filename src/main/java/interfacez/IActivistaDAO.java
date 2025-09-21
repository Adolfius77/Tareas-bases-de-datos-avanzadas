/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacez;

import java.util.List;
import model.Activista;
import model.Cliente;

/**
 *
 * @author USER
 */
public interface IActivistaDAO {

    boolean insertar(Activista activista);

    Activista obtenerPorId(int idActivista);

    List<Activista> obtenerTodos();

    boolean actualizar(Activista activista);

    boolean eliminar(int idActista);

    List<Activista> obtenerTodosPorFiltroModal(String filtro);

}
