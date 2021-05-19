package dev.jx.sga.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ae_id")
    private AnoEscolar anoEscolar;

    @Id
    @ManyToOne
    @JoinColumn(name = "alu_id")
    private Alumno alumno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grd_id")
    private Grado grado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sec_id")
    private Seccion seccion;

    @Column(name = "ma_fec_inscripcion", nullable = false)
    private LocalDateTime fechaInscripcion;
}
