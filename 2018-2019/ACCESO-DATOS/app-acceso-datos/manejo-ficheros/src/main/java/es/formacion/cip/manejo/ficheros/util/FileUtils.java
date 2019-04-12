package es.formacion.cip.manejo.ficheros.util;

import es.formacion.cip.manejo.ficheros.InformacionFichero;

import java.io.File;
import java.net.URL;

public class FileUtils {

    public static File getFile(String nombreFile) {

        File f;
        System.out.println("Información sobre el fichero:" + nombreFile);
        URL fileLocation = InformacionFichero.class.getClassLoader().getResource(nombreFile);

        f = new File(fileLocation.getFile());

        if (f.exists()){
            System.out.println("Nombre del fichero:  "+f.getName());
            System.out.println("Ruta              :  "+f.getPath());
            System.out.println("Se puede escribir :  "+f.canWrite());
            System.out.println("Tamaño            :  "+f.length());
            System.out.println("Es un directorio  :  "+f.isDirectory());
            System.out.println("Es un fichero     :  "+f.isFile());
        } else {
            System.out.println("No se ha encontrado el fichero :" + nombreFile);
        }
        return f;
    }

}
