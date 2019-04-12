package es.formacion.cip.mvc.dao;

import es.formacion.cip.mvc.modelo.Cliente;

import java.util.List;

public interface IClienteDao {
    public boolean registrar(Cliente cliente);
    public List<Cliente> obtener();
    public boolean actualizar(Cliente cliente);
    public boolean eliminar(Cliente cliente);
}
