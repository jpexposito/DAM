package es.formacion.cip.manejo.ficheros;



import es.formacion.cip.manejo.ficheros.util.FileUtils;

import java.io.File;
import java.net.URL;

public class InformacionFichero {

    public static void main(String[] args) {

        String nombreFichero = "fichero.xml";

        FileUtils.getFile(nombreFichero);

    }
}
