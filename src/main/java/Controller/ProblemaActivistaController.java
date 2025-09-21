package Controller;

import dao.ProblemaActivistaDAO;
import interfacez.IProblemaActivistaDAO;
import model.ProblemaActivista;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Activista;

public class ProblemaActivistaController {

    private final IProblemaActivistaDAO problemaActivistaDAO;

    public ProblemaActivistaController() {
        problemaActivistaDAO = new ProblemaActivistaDAO();
    }

    public boolean asignarAtivista(int idProblema, int idActivista) {
        if (idProblema <= 0 || idActivista <= 0) {
            System.out.printf("ids invalidos para la asignacion");
            return false;
        }
        ProblemaActivista relacion = new ProblemaActivista();
        relacion.setIdProblema(idProblema);
        relacion.setIdActivista(idActivista);

        return problemaActivistaDAO.insertar(relacion);
    }

    public List<ProblemaActivista> obtenerPorProblema(int idProblema) {
        if (idProblema <= 0) {
            System.out.printf("ids invalidos para la asignacion");
            return null;
        }
        return problemaActivistaDAO.obtenerPorProblema(idProblema);
    }

    public List<ProblemaActivista> obtenerPorActivista(int idActivista) {
        if (idActivista <= 0) {
            System.out.println("id del activista invalido");
            return null;
        }
        return problemaActivistaDAO.obtenerPorActivista(idActivista);
    }

    public boolean eliminarAsignacion(int idProblema, int idActivista) {
        if (idProblema <= 0 || idActivista <= 0) {
            System.err.printf("ids invalidos para la eliminacion");
            return false;
        }
        return problemaActivistaDAO.eliminar(idProblema, idActivista);
    }

    public DefaultTableModel obtenerTablaActivistasProblemas() {
        String[] columnas = {"ID ACTIVISTA", "ID PROBLEMA"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<ProblemaActivista> lista = problemaActivistaDAO.obtenerTodos();
        for (ProblemaActivista c : lista) {
            modelo.addRow(new Object[]{c.getIdProblema(), c.getIdActivista()});
        }
        return modelo;
    }

    public DefaultTableModel obtenerTablaAsignacionesPorFiltro(String filtro) {
        String[] columnas = {"ID Problema", "Problema", "ID Activista", "Activista"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        List<ProblemaActivista> lista = problemaActivistaDAO.obtenerTodosPorFiltro(filtro);

        for (ProblemaActivista pa : lista) {

            String nombreProblema = "Descripción del problema " + pa.getIdProblema();
            String nombreActivista = "Nombre del activista " + pa.getIdActivista();

            modelo.addRow(new Object[]{
                pa.getIdProblema(),
                nombreProblema,
                pa.getIdActivista(),
                nombreActivista
            });
        }
        return modelo;
    }
}
