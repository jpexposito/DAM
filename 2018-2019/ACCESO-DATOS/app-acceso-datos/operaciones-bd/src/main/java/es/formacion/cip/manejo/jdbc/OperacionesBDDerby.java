package es.formacion.cip.manejo.jdbc;

import java.sql.SQLException;

public class OperacionesBDDerby extends OperacionesBDUtils{


    public static final String DATABASE_NAME = "USERS";
    private static String dbDerbiUrl = "jdbc:derby:memory:testdb;create=true";


    public OperacionesBDDerby (String urlBD) throws SQLException {
        super(urlBD);

    }

    public static void main(String[] args) throws SQLException {
        OperacionesBDDerby app = new OperacionesBDDerby(dbDerbiUrl);

        app.operacionesBasicasBBDD();
    }

}
