package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "seccion")
public class Seccion implements Serializable {

    @Id
    @Column(name = "sec_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grd_id")
    private Grado grado;

    @Column(name = "sec_nombre", nullable = false)
    private String nombre;

    @Column(name = "sec_capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "sec_estado", nullable = false)
    private String estado;

    public Seccion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
