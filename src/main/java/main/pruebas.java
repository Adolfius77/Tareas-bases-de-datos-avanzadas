package main;

import Controller.ActivistaController;
import Controller.ClienteController;
import Controller.ProblemaActivistaController;
import Controller.ProblemaController;
import model.Activista;
import model.Cliente;
import model.Problema;
import model.ProblemaActivista;

import java.sql.Date;
import java.util.List;

public class pruebas {
    public static void main(String[] args) {

        ClienteController clienteCrl = new ClienteController();
        ActivistaController activistaCrl = new ActivistaController();
        ProblemaController problemaCrl = new ProblemaController();
        ProblemaActivistaController paCrl = new ProblemaActivistaController();

        System.out.println("--- INICIO DE PRUEBAS DEL SISTEMA ---");


        // PRUEBAS PARA CLIENTE

        System.out.println("\n--- Pruebas para el Cliente ---");
        boolean agregado = clienteCrl.agregarCliente("pedro", "cortinas 232", "6442612905");
        System.out.println("El cliente se ha agregado: " + agregado);

        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = clienteCrl.listarClientes();
        clientes.forEach(System.out::println);

        // PRUEBAS PARA ACTIVISTA
        System.out.println("\n\n--- Pruebas para los Activistas ---");
        boolean activistaAgregado = activistaCrl.agregarActivista("maria jose", "6442622809", Date.valueOf("2025-01-01"));
        System.out.println("Activista agregado: " + activistaAgregado);

        System.out.println("\n--- Lista de Activistas ---");
        List<Activista> activistas = activistaCrl.listarActivistas();
        activistas.forEach(System.out::println);

        if (!clientes.isEmpty() && !activistas.isEmpty()) {
            Cliente primerCliente = clientes.get(0);
            int idClientePrueba = primerCliente.getIdCliente();

            Activista primerActivista = activistas.get(0);
            int idActivistaPrueba = primerActivista.getIdActivista();

            // --- Pruebas de actualizacion de Cliente ---
            System.out.println("\n--- Actualizar Cliente ID: " + idClientePrueba + " ---");
            boolean actualizado = clienteCrl.actualizarCliente(idClientePrueba, "Juan p", "pollo", "131313131313");
            System.out.println("El cliente se ha actualizado: " + actualizado);
            clienteCrl.listarClientes().forEach(System.out::println);

            // --- Pruebas de actualizacion de Activista ---
            System.out.println("\n--- Actualizar Activista ID: " + idActivistaPrueba + " ---");
            boolean activistaActualizado = activistaCrl.actualizarActivista(idActivistaPrueba, "ana sofia", "111222333", Date.valueOf("2024-02-02"));
            System.out.println("El activista se ha actualizado: " + activistaActualizado);
            activistaCrl.listarActivistas().forEach(System.out::println);

            // PRUEBAS PARA PROBLEMA

            System.out.println("\n\n--- Pruebas para los Problemas ---");
            String descripcion = null;
            boolean problemaAgregado = problemaCrl.agregarProblema(Date.valueOf("2025-09-07"), null, "pendiente", idClientePrueba, descripcion);
            System.out.println("Problema agregado: " + problemaAgregado);
            List<Problema> problemas = problemaCrl.listarProblema();
            problemas.forEach(System.out::println);

            if (!problemas.isEmpty()) {
                Problema primerProblema = problemas.get(0);
                int idProblemaPrueba = primerProblema.getIdProblema();
                // PRUEBAS PARA PROBLEMA-ACTIVISTA
                System.out.println("\n\n--- Pruebas para Problema-Activista ---");
                System.out.println("\n--- Asignando Activista " + idActivistaPrueba + " a Problema " + idProblemaPrueba + " ---");
                boolean asignacion = paCrl.asignarAtivista(idProblemaPrueba, idActivistaPrueba);
                System.out.println("Asignacion exitosa: " + asignacion);

                // INICIO DE PRUEBAS DE ELIMINACION

                System.out.println("\n\n--- Pruebas de Eliminacion ---");

                // PASO 1: Eliminar la relacion
                System.out.println("\n--- Eliminando Asignacion ---");
                boolean asignacionEliminada = paCrl.eliminarAsignacion(idProblemaPrueba, idActivistaPrueba);
                System.out.println("Asignacion eliminada: " + asignacionEliminada);

                // PASO 2: Eliminar el problema
                System.out.println("\n--- Eliminando Problema ID: " + idProblemaPrueba + " ---");
                boolean problemaEliminado = problemaCrl.eliminarProblema(idProblemaPrueba);
                System.out.println("Problema eliminado: " + problemaEliminado);
            }

            // PASO 3: Eliminar el activista
            System.out.println("\n--- Eliminando Activista ID: " + idActivistaPrueba + " ---");
            boolean activistaEliminado = activistaCrl.eliminarActivista(idActivistaPrueba);
            System.out.println("Activista eliminado: " + activistaEliminado);

            // PASO 4: Eliminar el cliente
            System.out.println("\n--- Eliminando Cliente ID: " + idClientePrueba + " ---");
            boolean clienteEliminado = clienteCrl.eliminarCliente(idClientePrueba);
            System.out.println("El cliente se ha eliminado: " + clienteEliminado);

            System.out.println("\n--- Lista final de Clientes ---");
            clienteCrl.listarClientes().forEach(System.out::println);

        } else {
            System.out.println("No se pudieron ejecutar todas las pruebas porque no hay clientes o activistas iniciales.");
        }

        System.out.println("\n--- FIN DE LAS PRUEBAS ---");
    }
}