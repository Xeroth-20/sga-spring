package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "criterio_ev")
public class CriterioEv implements Serializable {

    @Id
    @Column(name = "cev_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cur_id")
    private Curso curso;

    @Column(name = "cev_descripcion", nullable = false)
    private String descripcion;

    public CriterioEv() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
