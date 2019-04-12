package es.formacion.cip.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Tarea_id")
    private Integer id;

    private Date fechaCreacion;
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Evento> eventos = new HashSet<>();


    public Tarea() {
    }

    /**
     * Constructor para trabajar con las tareas de la BBDD
     * @param fechaCreacion fecha de creacion de la tarea
     * @param nombre nombre de la tarea creada
     */
    public Tarea(String nombre,Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
    }

    /**
     * Constructor para el objeto tarea con los siguientes parametros
     * @param nombre nombre de la tarea
     * @param fechaCreacion fecha de creacion de la tarea
     * @param eventos eventos relacionados con la tarea
     */
    public Tarea(String nombre,Date fechaCreacion, Set<Evento> eventos) {
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.eventos = eventos;
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }
}
