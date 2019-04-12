package es.formacion.cip.mvc.dao;

import es.formacion.cip.mvc.conection.Conexion;
import es.formacion.cip.mvc.modelo.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements IClienteDao {

    public void crearBD() {
        Statement stm;
        Connection con;

        try{
            con=Conexion.conectar();
            stm= con.createStatement();
            stm.executeUpdate("Create table CLIENTE (id INTEGER , nombre varchar(30), apellidos varchar(30))");
            stm.close();
            con.close();
            System.out.println("Se ha creado la tabla CLIENTE en BBDD");
        } catch (Exception e) {
            System.out.println("Error: Se ha producido un error al crear la tabla de la BBDD");
            e.printStackTrace();
        }


    }

    @Override
    public boolean registrar(Cliente cliente) {
        boolean registrar = false;

        Statement stm;
        Connection con;

        String sql="INSERT INTO cliente values (NULL,'"+cliente.getNombre()+"','"+cliente.getApellido()+"')";

        try {
            con=Conexion.conectar();
            stm= con.createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();
            System.out.println("Se ha realzado la insercion en BBDD");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Cliente> obtener() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM CLIENTE ORDER BY ID";

        List<Cliente> listaCliente= new ArrayList<Cliente>();

        try {
            co= Conexion.conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Cliente c=new Cliente();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            co.close();
            System.out.println("Se han mostrado los datos de la tabla");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE CLIENTE SET nombre='"+cliente.getNombre()+"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getId();
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
            System.out.println("Se ha realzado la actualizacio  en BBDD");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getId();
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            eliminar=true;
            System.out.println("Se ha realzado la eliminacion en BBDD");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

}
