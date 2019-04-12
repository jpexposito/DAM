package es.formacion.cip.manejo.ficheros.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import es.formacion.cip.manejo.ficheros.InformacionFichero;
import es.formacion.cip.manejo.ficheros.util.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class ProcesaXMLXerces {

    static String nombreFichero = "localidad_38023.xml";

    public static void main(String[] args) {

        try {



            File fXmlFile = FileUtils.getFile(nombreFichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            // Obtenemos la etiqueta raiz
            Element elementRaiz = doc.getDocumentElement();
            // Iteramos sobre sus hijos
            NodeList hijos = elementRaiz.getChildNodes();
            for(int i=0;i<hijos.getLength();i++){
                Node nodo = hijos.item(i);
                if (nodo instanceof Element){
                    System.out.println(nodo.getNodeName());
                }
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
