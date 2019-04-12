package es.formacion.cip.mvc.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static final String DATABASE_NAME = "CLIENTES";
    private static String dbDerbiUrl = "jdbc:derby:memory:clientesDB;create=true";

    public static Connection conectar() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(dbDerbiUrl);
            if (con != null) {
                System.out.println("Se ha realizado la coneccion con la BBDD");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}
