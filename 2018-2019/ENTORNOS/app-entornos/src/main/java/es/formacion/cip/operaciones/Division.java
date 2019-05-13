package es.formacion.cip.operaciones;

public class Division extends Operacion {


    public Division(double numero1, double numero2) {

        super(numero1, numero2, '/');
        if(numero2==0) System.out.println("No se puede dividir entre cero");
        else this.setResultado (numero1 / numero2);

    }
}
