package es.formacion.cip.manejo.ficheros;


import es.formacion.cip.manejo.ficheros.util.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class LecturaEscrituraFichero {

    static String nombreFichero = "informacion.txt";

    public static void main(String[] args) {

        try {
            escrituraFichero();
            lecturaFichero();
        } catch (Exception e) {
            System.out.println("No se ha encontrado el fichero " + nombreFichero);
        }
    }

    private static void lecturaFichero() throws IOException {

        File f = FileUtils.getFile(nombreFichero);
        if (f.exists()){
            FileReader fileReader = new FileReader(f); // crear el flujo de entrada
            int i;
            while ((i = fileReader.read()) != -1) // se va leyendo un carácter
                System.out.println((char) i);
            fileReader.close(); // cerrar fichero
        }
    }

    private static void escrituraFichero() throws IOException {
        File f = FileUtils.getFile(nombreFichero);
        if (f.exists()){
            FileWriter fic = new FileWriter(f); // crear el flujo de salida
            String cadena = "Esto es una prueba de FileWriter";
            char[] cad = cadena.toCharArray(); //convierte un String a un array de caracteres.
                for (int i=0; i<cad.length; i++)
                    fic.write(cad[i]);  //se va escribiendo un carácter
                fic.append('*'); //añadimos al final un *
                fic.close(); // cerramos el fichero
        }

    }
}
