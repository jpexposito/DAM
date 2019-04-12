package es.formacion.cip.mvc.vista;

import es.formacion.cip.mvc.modelo.Cliente;

import java.util.List;

public class ViewCliente {
    public void verCliente(Cliente cliente) {
        System.out.println("Datos del Cliente: "+cliente);
    }

    public void verClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("Datos del Cliente: "+cliente);
        }
    }
}
