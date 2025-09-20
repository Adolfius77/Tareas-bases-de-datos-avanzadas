package Controller;

import dao.ProblemaActivistaDAO;
import interfacez.IProblemaActivistaDAO;
import model.ProblemaActivista;

import java.util.List;

public class ProblemaActivistaController {
    private final IProblemaActivistaDAO problemaActivistaDAO;
    public ProblemaActivistaController() {
        problemaActivistaDAO = new ProblemaActivistaDAO();
    }
    public boolean asignarAtivista(int idProblema, int idActivista) {
        if(idProblema <= 0 || idActivista <= 0) {
            System.out.printf("ids invalidos para la asignacion");
            return false;
        }
        ProblemaActivista relacion = new ProblemaActivista();
        relacion.setIdProblema(idProblema);
        relacion.setIdActivista(idActivista);

        return problemaActivistaDAO.insertar(relacion);
    }
    public List<ProblemaActivista> obtenerPorProblema(int idProblema) {
        if(idProblema <= 0) {
            System.out.printf("ids invalidos para la asignacion");
            return null;
        }
        return problemaActivistaDAO.obtenerPorProblema(idProblema);
    }
    public List<ProblemaActivista> obtenerPorActivista(int idActivista) {
        if(idActivista <= 0) {
            System.out.println("id del activista invalido");
            return null;
        }
        return problemaActivistaDAO.obtenerPorActivista(idActivista);
    }
    public boolean eliminarAsignacion(int idProblema, int idActivista) {
        if(idProblema <= 0 || idActivista <= 0) {
            System.err.printf("ids invalidos para la eliminacion");
            return false;
        }
        return problemaActivistaDAO.eliminar(idProblema, idActivista);
    }
}
