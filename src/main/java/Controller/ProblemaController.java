package Controller;

import dao.ProblemaDAO;
import interfacez.IProblemaDAO;
import model.Problema;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProblemaController {

    private final IProblemaDAO problemaDAO;
    public final List<String> estadosValidos = Arrays.asList("pendiente", "concluido", "cancelado");

    public ProblemaController() {
        this.problemaDAO = new ProblemaDAO();
    }

    public boolean agregarProblema(Date fchIni, Date fchFin, String estado, int idCliente, String descripcion) {
        if (fchIni == null) {
            System.err.println("la fecha de inicio es obligatoria");
            return false;
        }
        if (estado == null) {
            System.err.println("estado invalido deber ser: pendiente, concluido o cancelado");
            return false;
        }
        if (idCliente <= 0) {
            System.err.println("idCliente invalido");
            return false;
        }
        Problema problema = new Problema();
        problema.setFchIni(fchIni);
        problema.setFchFin(fchFin);
        problema.setEstado(estado);
        problema.setIdCliente(idCliente);
        problema.setDescripcion(descripcion);

        return problemaDAO.insertar(problema);
    }

    public Problema obtenerProblema(int idProblema) {
        if (idProblema <= 0) {
            System.err.println("idProblema invalido");
            return null;
        }
        return problemaDAO.obtenerPorId(idProblema);
    }

    public List<Problema> listarProblema() {
        return problemaDAO.obtenerTodos();
    }

    public boolean actualizarProblema(int idProblema, Date fchIni, Date fchFin, String estado, int idCliente, String descripcion) {
        if (idProblema <= 0) {
            System.err.println("idProblema invalido");
            return false;
        }
        if (fchIni == null) {
            System.err.println("la fecha de inicio es obligatoria");
            return false;
        }
        if (estado == null) {
            System.out.println("estado invalido deber ser: pendiente, concluido o cancelado");
            return false;
        }
        if (idCliente <= 0) {
            System.err.println("idCliente invalido");
            return false;
        }
        Problema problema = new Problema();
        problema.setIdProblema(idProblema);
        problema.setFchIni(fchIni);
        problema.setFchFin(fchFin);
        problema.setEstado(estado);
        problema.setIdCliente(idCliente);
        problema.setDescripcion(descripcion);
        return problemaDAO.actualizar(problema);

    }

    public boolean eliminarProblema(int idProblema) {
        if (idProblema <= 0) {
            System.err.println("idProblema invalido");
            return false;
        }
        return problemaDAO.eliminar(idProblema);
    }

    public DefaultTableModel obtenerTablaProblemas() {
        String[] columnas = {"ID", "DESCRIPCIÓN", "ESTADO", "INICIO", "FIN"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Problema> lista = problemaDAO.obtenerTodos();
        for (Problema c : lista) {
            modelo.addRow(new Object[]{c.getIdProblema(), c.getDescripcion(), c.getEstado(), c.getFchIni(), c.getFchFin()});
        }
        return modelo;
    }
}
