package es.formacion.cip.operacion;

import es.formacion.cip.operaciones.Division;
import es.formacion.cip.utilidades.Visualizar;
import org.junit.Assert;
import org.junit.Test;

public class OperacionTest {

    public static final int Valor_1 = 8;
    public static final int Valor_2 = 2;
    private Division division;


    @Test
    public void verificarContructor() {

        Assert.assertNotNull("El objecto division es nulo", division);
        Assert.assertNotNull("El parametro 1 es nulo", division.getNumero1());
        Assert.assertNotNull("El parametro 2 es nulo", division.getNumero2());
        Assert.assertNotNull("La division es nula es nulo", division.getOperacion());

        Assert.assertEquals("El valor en Numero 1 no es el correcto", division.getNumero1(),Valor_1,0);
        Assert.assertEquals("El valor en Numero 2 no es el correcto", division.getNumero2(),Valor_2,0);
        Assert.assertEquals("El valor de la division no es el correcto", division.getOperacion(),'/');
        Visualizar.imprimirPorConsola(division.getResultado(), division.getOperacion());
    }

}
