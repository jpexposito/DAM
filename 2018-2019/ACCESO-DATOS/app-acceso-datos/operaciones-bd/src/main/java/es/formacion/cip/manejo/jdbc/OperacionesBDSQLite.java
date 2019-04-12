package es.formacion.cip.manejo.jdbc;

import java.sql.SQLException;

public class OperacionesBDSQLite extends OperacionesBDUtils{


    public static final String DATABASE_NAME = "USERS";
    private static String dbDerbiUrl = "jdbc:sqlite:memory:testdb;create=true";


    public OperacionesBDSQLite(String urlBD) throws SQLException {
        super(urlBD);

    }

    public static void main(String[] args) throws SQLException {
        OperacionesBDSQLite app = new OperacionesBDSQLite(dbDerbiUrl);

        app.operacionesBasicasBBDD();
    }

}
