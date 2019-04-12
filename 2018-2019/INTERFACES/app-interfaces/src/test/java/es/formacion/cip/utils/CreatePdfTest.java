package es.formacion.cip.utils;

import es.formacion.cip.controler.TareaTest;
import es.formacion.cip.model.entity.Tarea;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CreatePdfTest {

    CreatePdf createPdf;
    List<Tarea> listaTareas = null;
    TareaTest tareaTest = null;

    @Before
    public void before(){
        if (listaTareas == null) {
            tareaTest = new TareaTest();
            listaTareas = new ArrayList<>();
            listaTareas.add(tareaTest.insertarYRecuperarTarea());
        }
    }

    @Test
    public void crearTestEjemplo() {
        createPdf = new CreatePdf();
        createPdf.crearDocumento();
    }

    @Test
    public void crearTestEjemploConDatos() {

        createPdf = new CreatePdf();
        createPdf.crearDocumento("PDF con Datos","pdf-con-datos", listaTareas);
    }
}
