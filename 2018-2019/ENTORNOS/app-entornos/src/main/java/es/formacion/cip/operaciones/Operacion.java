package es.formacion.cip.operaciones;

public class Operacion {
    double numero1;
    double numero2;
    double resultado;
    char operacion;

    /**
     * Constructor que setea los valores 1 y 2 y la operacion a realizar
     * @param n1 valor 1 de la operacion
     * @param n2 valor 2 de la operacion
     * @param operacion operacion a realizar
     */
    public Operacion(double n1, double n2, char operacion) {

        this.numero1 = n1;
        this.numero2 = n2;
        this.operacion = operacion;
    }


    public void setResultado(double resultado){
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return new String(this.numero1 +" "+this.operacion+" "+this.numero2 +" = "+this.resultado);

    }

    public double getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public char getOperacion() {
        return operacion;
    }
}
