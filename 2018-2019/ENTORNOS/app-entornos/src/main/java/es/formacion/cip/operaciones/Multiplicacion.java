package es.formacion.cip.operaciones;

public class Multiplicacion extends Operacion{


    public Multiplicacion(double numero1, double numero2) {

        super(numero1, numero2, '*');
        this.setResultado (numero1 * numero2);
    }
}
