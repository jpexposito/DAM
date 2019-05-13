package es.formacion.cip.operacion;

import es.formacion.cip.operaciones.Division;
import es.formacion.cip.operaciones.Operacion;
import es.formacion.cip.operaciones.Resta;
import es.formacion.cip.operaciones.Suma;
import es.formacion.cip.utilidades.Visualizar;
import org.junit.Assert;
import org.junit.Test;

public class OperacionTest {

    public static final int Valor_1 = 8;
    public static final int Valor_2 = 2;
    private Operacion operacion;



    @Test
    public void divisionTest() {

        operacion = new Division(Valor_1,Valor_2);

        verificarOperacion('/');
    }

    @Test
    public void sumaTest() {

        operacion = new Suma(Valor_1,Valor_2);

        verificarOperacion('+');
    }

    @Test
    public void restaTest() {

        operacion = new Resta(Valor_1,Valor_2);
        verificarOperacion('-');
    }

    private void verificarOperacion(char op) {
        Assert.assertNotNull("El objecto division es nulo", operacion);
        Assert.assertNotNull("El parametro 1 es nulo", operacion.getNumero1());
        Assert.assertNotNull("El parametro 2 es nulo", operacion.getNumero2());
        Assert.assertNotNull("La division es nula es nulo", operacion.getOperacion());

        Assert.assertEquals("El valor en Numero 1 no es el correcto", operacion.getNumero1(),Valor_1,0);
        Assert.assertEquals("El valor en Numero 2 no es el correcto", operacion.getNumero2(),Valor_2,0);
        Assert.assertEquals("El valor de la division no es el correcto", operacion.getOperacion(),op);
        Visualizar.imprimirPorConsola(operacion.getNumero1(), operacion.getNumero2(),operacion.getResultado(), op);
    }


}
