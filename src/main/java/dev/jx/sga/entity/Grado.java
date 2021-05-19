package dev.jx.sga.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "grado")
public class Grado implements Serializable {

    @Id
    @Column(name = "grd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "grado")
    private List<Seccion> secciones;

    @OneToMany(mappedBy = "grado")
    private List<Curso> cursos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ae_id")
    private AnoEscolar anoEscolar;

    @Column(name = "grd_nombre", nullable = false)
    private String nombre;

    @Column(name = "grd_estado", nullable = false)
    private String estado;

    public Grado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public AnoEscolar getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(AnoEscolar anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
