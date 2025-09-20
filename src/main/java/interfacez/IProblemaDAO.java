/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacez;

import java.util.List;
import model.Problema;

/**
 *
 * @author USER
 */
public interface IProblemaDAO {
    boolean insertar(Problema problema);
    List<Problema> obtenerTodos();
    boolean actualizar(Problema problema);
    boolean eliminar(int idProblema);
    Problema obtenerPorId(int idProblema);

}
