package es.formacion.cip.controler;

import es.formacion.cip.model.entity.Evento;
import es.formacion.cip.model.entity.Tarea;
import es.formacion.cip.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class TareaControler {


    public void insertartTarea(String nombre, Date fechaCreacion, Set<Evento> eventos) {

        Session session = null;
        Transaction tx=null;


        Tarea tarea = new Tarea(nombre, fechaCreacion,eventos);
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            session.save(tarea);

            tx.commit();

        } catch (Exception e) {
            System.out.println("Se ha generado un error guardando la tarea:" +e.getMessage());

        } finally {
            if(session != null) {
                session.close();
            }
        }


    }

    public Tarea obtenerTarea(String nombre) {

        Session session = null;

        try {
            session = HibernateUtil.getSession();

            Query query = session.createQuery("SELECT t FROM Tarea t where nombre=:nombre");
            query.setString("nombre", nombre);
            List<Tarea> tareas = query.list();

            return tareas.get(0);


        } catch (Exception e) {
            System.out.println("Se ha generado un error guardando la tarea:" +e.getMessage());

        } finally {
            if(session != null) {
                session.close();
            }
        }
       return null;
    }
}
