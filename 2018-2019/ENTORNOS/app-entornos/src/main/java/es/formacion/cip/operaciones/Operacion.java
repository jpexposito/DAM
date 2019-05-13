package es.formacion.cip.operaciones;

abstract class Operacion {
    private double numero1;
    private double numero2;
    private double resultado;
    private char operacion;

    /**
     * Constructor que setea los valores 1 y 2 y la operacion a realizar
     * @param numero1 valor 1 de la operacion
     * @param numero2 valor 2 de la operacion
     * @param operacion operacion a realizar
     */
    public Operacion(double numero1, double numero2, char operacion) {

        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion = operacion;
    }


    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado){
        this.resultado = resultado;
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
