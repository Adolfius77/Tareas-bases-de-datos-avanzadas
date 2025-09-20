package interfacez;

import java.util.List;
import model.ProblemaActivista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author USER
 */
public interface IProblemaActivistaDAO {
    boolean insertar(ProblemaActivista relacion);
    List<ProblemaActivista> obtenerPorProblema(int idProblema);
    List<ProblemaActivista> obtenerPorActivista(int idActivista);
    boolean eliminar(int idProblema, int idActivista);
}