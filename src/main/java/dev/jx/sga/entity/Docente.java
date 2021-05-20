package dev.jx.sga.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "docente")
public class Docente implements Serializable {

    @Id
    @Column(name = "doc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "docente")
    private List<CursoDocente> cursosAsignados;

    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "per_id", unique = true)
    private Persona persona;

    @Column(name = "doc_estado", nullable = false)
    private String estado;

    public Docente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CursoDocente> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCursosAsignados(List<CursoDocente> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
