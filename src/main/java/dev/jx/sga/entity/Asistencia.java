package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "das_id")
    private DiaAsistencia diaAsistencia;

    @Id
    @ManyToOne
    @JoinColumn(name = "alu_id")
    private Alumno alummno;

    @Column(name = "as_marca", nullable = false)
    private String marca;

    @Column(name = "as_observacion")
    private String observacion;
}
