package Controller;

import dao.ProblemaDAO;
import interfacez.IProblemaDAO;
import model.Problema;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class ProblemaController {
    private final IProblemaDAO problemaDAO;
    public final List<String> estadosValidos = Arrays.asList("pendiente","concluido","cancelado");

    public ProblemaController() {
        this.problemaDAO = new ProblemaDAO();
    }
    public boolean agregarProblema(Date fchIni, Date fchFin, String estado, int idCliente) {
      if(fchIni == null){
          System.err.println("la fecha de inicio es obligatoria");
          return false;
      }
      if(estado == null){
          System.err.println("estado invalido deber ser: pendiente, concluido o cancelado");
          return false;
      }
      if(idCliente <= 0){
          System.err.println("idCliente invalido");
          return false;
      }
      Problema problema = new Problema();
      problema.setFchIni(fchIni);
      problema.setFchFin(fchFin);
      problema.setEstado(estado);
      problema.setIdCliente(idCliente);

      return problemaDAO.insertar(problema);
    }
    public Problema obtenerProblema(int idProblema) {
        if(idProblema <= 0){
            System.err.println("idProblema invalido");
            return null;
        }
        return problemaDAO.obtenerPorId(idProblema);
    }

    public List<Problema> listarProblema() {
        return problemaDAO.obtenerTodos();
    }
    public boolean actualizarProblema(int idProblema, Date fchIni, Date fchFin,String estado, int idCliente) {
        if(idProblema <= 0){
            System.err.println("idProblema invalido");
            return false;
        }
        if(fchIni == null){
            System.err.println("la fecha de inicio es obligatoria");
            return false;
        }
        if(estado == null){
            System.out.println("estado invalido deber ser: pendiente, concluido o cancelado");
            return false;
        }
        if(idCliente <= 0){
            System.err.println("idCliente invalido");
            return false;
        }
        Problema problema = new Problema();
        problema.setFchIni(fchIni);
        problema.setFchFin(fchFin);
        problema.setEstado(estado);
        problema.setIdCliente(idCliente);
        return problemaDAO.actualizar(problema);

    }
    public boolean eliminarProblema(int idProblema) {
        if(idProblema <= 0){
            System.err.println("idProblema invalido");
            return false;
        }
        return problemaDAO.eliminar(idProblema);
    }
}
