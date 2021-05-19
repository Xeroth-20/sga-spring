package dev.jx.sga.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Id
    @Column(name = "cur_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "curso")
    private List<CriterioEv> criteriosEv;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grd_id")
    private Grado grado;

    @Column(name = "cur_nombre", nullable = false)
    private String nombre;

    @Column(name = "cur_min_aprobatorio", nullable = false)
    private Float minimoAprobatorio;

    @Column(name = "cur_estado", nullable = false)
    private String estado;

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CriterioEv> getCriteriosEv() {
        return criteriosEv;
    }

    public void setCriteriosEv(List<CriterioEv> criteriosEv) {
        this.criteriosEv = criteriosEv;
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

    public Float getMinimoAprobatorio() {
        return minimoAprobatorio;
    }

    public void setMinimoAprobatorio(Float minimoAprobatorio) {
        this.minimoAprobatorio = minimoAprobatorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
