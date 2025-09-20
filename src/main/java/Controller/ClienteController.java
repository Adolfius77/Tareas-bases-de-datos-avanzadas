package Controller;

import dao.ClienteDAO;
import interfacez.IClienteDAO;
import model.Cliente;

import java.util.List;

public class ClienteController {
    private final IClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
public boolean agregarCliente(String nombre, String direccion, String telefonos) {
        if(nombre == null || nombre.trim().isEmpty()){
            System.out.println("el nombre del cliente no puede estar vacio");
            return false;
        }
        if(direccion == null) direccion = "";
        if(telefonos == null) telefonos = "";

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre.trim());
        cliente.setDireccion(direccion.trim());
        cliente.setTelefonos(telefonos.trim());

        return clienteDAO.insertar(cliente);
}
    public boolean actuzalizarCliente(int idCliente, String nombre, String direccion, String telefonos) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("el nombre del cliente no puede estar vacio");
            return false;
        }
        if (direccion == null) direccion = "";
        if (telefonos == null) telefonos = "";

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre.trim());
        cliente.setDireccion(direccion.trim());
        cliente.setTelefonos(telefonos.trim());

        return clienteDAO.actualizar(cliente);
    }

    public Cliente obtenerCliente(int id_cliente) {
        if (id_cliente <= 0) {
            System.err.println("id del cliente invalido");
            return null;
        }
        return clienteDAO.obtenerPorId(id_cliente);

    }

    public List<Cliente> listarClientes() {
        return clienteDAO.obtenerTodos();
    }
    public boolean actualizarCliente(int idCliente, String nombre, String direccion, String telefonos) {
        if(idCliente <= 0) {
            System.err.println("id del cliente invalido");
            return false;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            System.err.println("nombre del cliente no puede estar vacio");
        }
        if (direccion == null) direccion = "";
        if (telefonos == null) telefonos = "";

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setNombre(nombre.trim());
        cliente.setDireccion(direccion.trim());
        cliente.setTelefonos(telefonos.trim());

        return clienteDAO.actualizar(cliente);
    }

    public boolean eliminarCliente(int id_cliente) {
        if (id_cliente <= 0) {
            System.err.println("id del cliente invalido");
        }
        return clienteDAO.eliminar(id_cliente);
    }


}
