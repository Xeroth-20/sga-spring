package dev.jx.sga.entity;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "curso_docente")
public class CursoDocente implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "cur_id")
    private Curso curso;

    @Id
    @ManyToOne
    @JoinColumn(name = "sec_id")
    private Seccion seccion;

    @Id
    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Docente docente;

    @Column(name = "cd_fec_asig", nullable = false)
    private LocalDate fechaAsignacion;
}
