package es.formacion.cip.utilidades;

public class Visualizar {

    public static void imprimirPorConsola(double resultado, char operacion) {
        System.out.println("Resultado: "+resultado+"de la operacion "+operacion);

    }

    public static String obtenerResultado(double resultado) {
        return new String("Resultado de la operacion:"+resultado);
    }

    public static String obtenerResultado(String mensaje, double resultado) {
        return new String(mensaje+":"+resultado);
    }
}
