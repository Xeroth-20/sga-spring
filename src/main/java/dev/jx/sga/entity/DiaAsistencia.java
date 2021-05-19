package dev.jx.sga.entity;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "dia_asistencia")
public class DiaAsistencia implements Serializable {

    @Id
    @Column(name = "das_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hc_id")
    private HorarioCurso horarioCurso;

    @Column(name = "das_fecha")
    private LocalDate fecha;

    @Column(name = "das_estado")
    private String estado;
}
