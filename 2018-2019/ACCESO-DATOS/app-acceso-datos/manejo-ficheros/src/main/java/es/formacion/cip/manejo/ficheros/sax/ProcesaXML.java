package es.formacion.cip.manejo.ficheros.sax;

import es.formacion.cip.manejo.ficheros.InformacionFichero;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class ProcesaXML {

    static String nombreFichero = "fichero.xml";

    public static void main(String[] args) {

        try {
            // Creamos la factoria de parseadores por defecto
            XMLReader reader = XMLReaderFactory.createXMLReader();
            // Añadimos nuestro manejador al reader
            reader.setContentHandler(new ManejadorEjemplo());
            URL fileLocation = InformacionFichero.class.getClassLoader().getResource(nombreFichero);
            // Procesamos el xml de ejemplo
            reader.parse(new InputSource(new FileInputStream(fileLocation.getFile())));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
