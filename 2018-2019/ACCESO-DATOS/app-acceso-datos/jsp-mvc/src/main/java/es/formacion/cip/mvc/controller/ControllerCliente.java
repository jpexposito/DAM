package es.formacion.cip.mvc.controller;

import es.formacion.cip.mvc.dao.ClienteDaoImpl;
import es.formacion.cip.mvc.dao.IClienteDao;
import es.formacion.cip.mvc.modelo.Cliente;
import es.formacion.cip.mvc.vista.ViewCliente;

import java.util.ArrayList;
import java.util.List;

public class ControllerCliente {

    private ViewCliente vista= new ViewCliente();

    public ControllerCliente() {
    }

    //llama al DAO para guardar un cliente
    public void crearBD() {
        IClienteDao dao= new ClienteDaoImpl();
        ((ClienteDaoImpl) dao).crearBD();
    }

    //llama al DAO para guardar un cliente
    public void registrar(Cliente cliente ) {
        IClienteDao dao= new ClienteDaoImpl();
        dao.registrar(cliente);
    }

    //llama al DAO para actualizar un cliente
    public void actualizar(Cliente cliente) {
        IClienteDao dao= new  ClienteDaoImpl();
        dao.actualizar(cliente);
    }

    //llama al DAO para eliminar un cliente
    public void eliminar(Cliente cliente) {
        IClienteDao dao= new  ClienteDaoImpl();
        dao.eliminar(cliente);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        IClienteDao dao= new  ClienteDaoImpl();
        clientes=dao.obtener();
        vista.verClientes(clientes);
    }
}
