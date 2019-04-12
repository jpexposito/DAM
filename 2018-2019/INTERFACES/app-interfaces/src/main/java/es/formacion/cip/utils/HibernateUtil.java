package es.formacion.cip.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {


    private static SessionFactory sessionFactory;


     public static SessionFactory getSessionFactory() {

         try {
             // Create the SessionFactory from standard (hibernate.cfg.xml)
             // config file.
             if (sessionFactory == null) {
                 sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
             }
         } catch (Throwable ex) {
             // Log the exception.
             System.err.println("Initial SessionFactory creation failed." + ex);
             throw new ExceptionInInitializerError(ex);
         }

        return sessionFactory;
     }

     public static Session getSession() {
        return getSessionFactory().openSession();
     }





}
