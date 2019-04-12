package es.formacion.cip.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Evento")
@AssociationOverrides({
        @AssociationOverride(name = "pk_tarea",
                joinColumns = @JoinColumn(name = "Tarea_id")),
        })
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Event_id")
    private Integer id;

    private String nombre;

    public Evento() { }

    public Evento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
