package Controller;

import dao.ActivistaDAO;
import interfacez.IActivistaDAO;
import model.Activista;

import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Problema;

public class ActivistaController {

    private IActivistaDAO activistaDAO;

    public ActivistaController() {
        activistaDAO = new ActivistaDAO();
    }

    public boolean agregarActivista(String nombre, String telefono, Date fchIngreso) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("el nombre del activista no puede ser vacio");
            return false;
        }
        if (fchIngreso == null) {
            System.out.printf("la fecha de ingreso es obligatoria");
            return false;
        }
        if (telefono == null) {
            telefono = "";
        }
        Activista activista = new Activista();
        activista.setNombre(nombre.trim());
        activista.setTelefono(telefono.trim());
        activista.setFchIngreso(fchIngreso);

        return activistaDAO.insertar(activista);
    }

    public Activista obetenerActivista(int idActivista) {
        if (idActivista <= 0) {
            System.err.println("id del activista invalido");
            return null;
        }
        return activistaDAO.obtenerPorId(idActivista);
    }

    public List<Activista> listarActivistas() {
        return activistaDAO.obtenerTodos();
    }

    public boolean actualizarActivista(int idActivista, String nombre, String telefono, Date fchIngreso) {
        if (idActivista <= 0) {
            System.err.println("id del activista no puede ser vacio");
            return false;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("nombre del activista no puede ser vacio");
            return false;
        }
        if (fchIngreso == null) {
            System.err.println("la fecha de ingreso es obligatoria");
            return false;
        }
        if (telefono == null) {
            telefono = "";
        }
        Activista activista = new Activista();
        activista.setIdActivista(idActivista);
        activista.setNombre(nombre.trim());
        activista.setTelefono(telefono.trim());
        activista.setFchIngreso(fchIngreso);

        return activistaDAO.actualizar(activista);

    }

    public boolean eliminarActivista(int idActivista) {
        if (idActivista <= 0) {
            System.err.println("id del activista no puede ser vacio");
            return false;
        }
        return activistaDAO.eliminar(idActivista);
    }
    public DefaultTableModel obtenerTablaActivistas() {
        String[] columnas = {"ID", "NOMBRE", "TELEFONO", "FECHA INGRESO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Activista> lista = activistaDAO.obtenerTodos();
        for (Activista c : lista) {
            modelo.addRow(new Object[]{c.getIdActivista(), c.getNombre(), c.getTelefono(), c.getFchIngreso()});
        }
        return modelo;
    }
    public DefaultTableModel obtenerTablaClientesPorFiltroModal(String filtro) {
        String[] columnas = {"ID", "NOMBRE", "TELEFÓNO","FECHA INGRESO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Activista> lista = activistaDAO.obtenerTodosPorFiltroModal(filtro);
        for (Activista c : lista) {
            modelo.addRow(new Object[]{c.getIdActivista(), c.getNombre(), c.getTelefono(), c.getFchIngreso()});
        }
        return modelo;
    }
}
