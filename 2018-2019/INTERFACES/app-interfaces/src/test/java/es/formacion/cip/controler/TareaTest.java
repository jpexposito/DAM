package es.formacion.cip.controler;

import es.formacion.cip.model.entity.Evento;
import es.formacion.cip.model.entity.Tarea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TareaTest {

    public static final String NOMBRE_TEST_TAREA = "pepe";
    public static final String NOMBRE_EVENTO = "Nombre_Evento";
    TareaControler tareaControler = null;

    @Before
    public void before() {
        if (tareaControler == null)
            tareaControler = new TareaControler();
    }

    @Test
    public void insertarYRecuperarTareaTest() {
        Date fechaCreacion = new Date();

        tareaControler.insertartTarea(NOMBRE_TEST_TAREA, fechaCreacion,null);

        Tarea tareaObtenida = tareaControler.obtenerTarea(NOMBRE_TEST_TAREA);

        Assert.assertNotNull("Se ha obtenido la tarea nula", tareaObtenida);
        Assert.assertEquals("No se ha obtenido el resultado esperado en tarea", tareaObtenida.getNombre(), NOMBRE_TEST_TAREA);
    }

    @Test
    public void insertarYRecuperarTareaYEventosTest() {
        Tarea tareaObtenida = insertarYRecuperarTarea();

        Assert.assertNotNull("Se ha obtenido la tarea nula", tareaObtenida);
        Assert.assertEquals("No se ha obtenido el resultado esperado en tarea", tareaObtenida.getNombre(), NOMBRE_TEST_TAREA);
        Assert.assertNotNull("Se ha obtenido una lista de eventos nula ", tareaObtenida.getEventos());
        //tareaObtenida.setEventos(eventoControler.obtenerEventos(tareaObtenida.getId()));
        Assert.assertTrue("La lista de eventos es 0 o nula ", tareaObtenida.getEventos().size() > 0);


    }
    public Tarea insertarYRecuperarTarea() {
        Date fechaCreacion = new Date();
        Set<Evento> eventos = new HashSet<Evento>();

        before();
        Evento evento = new Evento(NOMBRE_EVENTO);
        eventos.add(evento);

        tareaControler.insertartTarea(NOMBRE_TEST_TAREA, fechaCreacion,eventos);

        return tareaControler.obtenerTarea(NOMBRE_TEST_TAREA);

    }

}
