package es.formacion.cip.operaciones;

public class Operacion {
    double n1;
    double n2;
    double res;
    char operacion;


    public Operacion(double n1, double n2, char operacion) {

        this.n1 = n1;
        this.n2 = n2;
        this.operacion = operacion;
    }


    public void setRes( double res){
        this.res = res;

        System.out.println(this.n1+" "+this.operacion+" "+this.n2+" = "+this.res);

    }
}
