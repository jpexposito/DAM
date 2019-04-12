package es.formacion.cip.manejo.jdbc;

import java.sql.*;

public class OperacionesBDUtils {


    public static final String DATABASE_NAME = "USERS";

    Connection conn;
    String urlBD;

    public OperacionesBDUtils(String dbUrl ) throws SQLException {
        urlBD = dbUrl;
        crearConeccionBD();
    }

    public OperacionesBDUtils() {

    }

    public void crearConeccionBD() throws SQLException {
        // -------------------------------------------
        // URL format is
        // jdbc:derby:<direccion local donde se almacena la BBDD>
        // -------------------------------------------

        // Creamos la coneccion con la BBDD
        if (conn == null) {
            conn = DriverManager.getConnection(urlBD);
        }
    }


    public void operacionesBasicasBBDD() throws SQLException {

        // creamos la tabla users, con los campos id (clave primaria, y nombre)
        crearRegistros();
        // mostramos el contenido de la BBDD creada
        mostrarContenidoBD();
        // Eliminamos un registro de la BBDD
        //eleminarRegristro(1);
        //eleminarRegristro(2);
        // Mostramos el contenido de la BBDD modificada

        crearRegistrosNuevos();
        mostrarContenidoBD();

    }

    /**
     * Muestra el contenido de la BBDD
     * @throws SQLException
     */
    private void mostrarContenidoBD() throws SQLException {

        System.out.println("Se muestra el contenido de la BBDD");

        Statement stmt = crearStatement();
        // realizamos una consulta sobre BBDD
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + DATABASE_NAME);

        // mostramos el resultado de los elemenos que se encuentran en BBDD
        while (rs.next()) {
            System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
        }

        rs.close();

        cerrarStatement(stmt);
    }

    /**
     * Crea los registros dentro de BBDD
     * @throws SQLException
     */
    private void crearRegistros() throws SQLException {

        Statement stmt = crearStatement();

        stmt.executeUpdate("Create table users (id int primary key, name varchar(30))");
        // realizamos la insercion de dos usuarios: Juan y Pedro
        stmt.executeUpdate("insert into users values (1,'Juan')");
        stmt.executeUpdate("insert into users values (2,'Pedro')");

        cerrarStatement(stmt);


    }

    private void eleminarRegristro(int id) {

        Statement stmt = null;
        try {
            stmt = crearStatement();
            stmt.execute("DELETE FROM "+ DATABASE_NAME +" WHERE id=+id");
            cerrarStatement(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * Crea los registros dentro de BBDD
     * @throws SQLException
     */
    private void crearRegistrosNuevos() throws SQLException {

        Statement stmt = crearStatement();

        // realizamos la insercion de dos usuarios: Juan y Pedro
        stmt.executeUpdate("insert into users values (3,'Pepe')");
        stmt.executeUpdate("insert into users values (4,'Lucas')");

        cerrarStatement(stmt);


    }

    private Statement crearStatement() throws SQLException {
        //crea la instancia para ejecutar la operacion


        Statement stmt = null;
        try {

            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    private void cerrarStatement(Statement stmt ) {

        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
