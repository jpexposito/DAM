package es.formacion.cip.mvc.demo;

import es.formacion.cip.mvc.controller.ControllerCliente;
import es.formacion.cip.mvc.modelo.Cliente;

public class CrudClientes {

    public static void main(String[] args) {



        Cliente cliente = new Cliente("Juan", "Perez");

        // controlador
        ControllerCliente controller = new ControllerCliente();

        // creamos la tabla de BBDD
        controller.crearBD();

        // guarda un cliente a través del controlador
        controller.registrar(cliente);

        // ver clientes
        controller.verClientes();

        // editar un cliente por medio del id
        cliente.setId(1);
        cliente.setNombre("Santiago");
        controller.actualizar(cliente);

        // eliminar un cliente por medio del id
        cliente.setId(1);
        controller.eliminar(cliente);
    }
}
