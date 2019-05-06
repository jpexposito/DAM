package es.formacion.cip.operacion;

import es.formacion.cip.operaciones.Operacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperacionTest {

    public static final int Valor_1 = 1;
    public static final int Valor_2 = 2;
    private Operacion operacion;


    @Test
    public void verificarContructor() {

        operacion = new Operacion(Valor_1, Valor_2,'/');
        Assert.assertNotNull("El objecto operacion es nulo",operacion);
        Assert.assertNotNull("El parametro 1 es nulo",operacion.getNumero1());
        Assert.assertNotNull("El parametro 2 es nulo",operacion.getNumero2());
        Assert.assertNotNull("La operacion es nula es nulo",operacion.getOperacion());

        Assert.assertEquals("El valor en Numero 1 no es el correcto",operacion.getNumero1(),Valor_1,0);
        Assert.assertEquals("El valor en Numero 2 no es el correcto",operacion.getNumero2(),Valor_2,0);
        Assert.assertEquals("El valor de la operacion no es el correcto",operacion.getOperacion(),'/');
    }

}
