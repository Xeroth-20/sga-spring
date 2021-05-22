package dev.jx.sga.entity;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {

    @EmbeddedId
    private MatriculaId id = new MatriculaId();

    @MapsId("anoEscolarId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "ae_id")
    private AnoEscolar anoEscolar;

    @MapsId("alumnoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "alu_id")
    private Alumno alumno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grd_id")
    private Grado grado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sec_id")
    private Seccion seccion;

    @Column(name = "ma_fec_inscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    @Column(name = "ma_estado", nullable = false)
    private String estado;

    public Matricula() {
    }

    public MatriculaId getId() {
        return id;
    }

    public void setId(MatriculaId id) {
        this.id = id;
    }

    public AnoEscolar getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(AnoEscolar anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
