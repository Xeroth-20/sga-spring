package dev.jx.sga.entity;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "curso_docente")
public class CursoDocente implements Serializable {

    @EmbeddedId
    private CursoDocenteId id = new CursoDocenteId();

    @MapsId("cursoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "cur_id")
    private Curso curso;

    @MapsId("seccionId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "sec_id")
    private Seccion seccion;

    @MapsId("docenteId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "doc_id")
    private Docente docente;

    @Column(name = "cd_fec_asig", nullable = false)
    private LocalDate fechaAsignacion;

    public CursoDocente() {
    }

    public CursoDocenteId getId() {
        return id;
    }

    public void setId(CursoDocenteId id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
