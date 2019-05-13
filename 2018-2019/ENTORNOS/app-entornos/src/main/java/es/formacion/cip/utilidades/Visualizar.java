package es.formacion.cip.utilidades;

public class Visualizar {

    public static void imprimirPorConsola(double resultado, char operacion) {
        System.out.println("Resultado: "+resultado+"de la operacion "+operacion);

    }

    public static void imprimirPorConsola(double numero1, double numero2,double resultado, char operacion) {
        System.out.println("El Resultado: "+resultado+" de la operacion "+operacion+"," +
                " de los numeros:"+numero1+", y "+numero2);

    }

    public static String obtenerResultado(double resultado) {
        return new String("Resultado de la operacion:"+resultado);
    }

    public static String obtenerResultado(String mensaje, double resultado) {
        return new String(mensaje+":"+resultado);
    }
}
