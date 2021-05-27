package dev.jx.sga.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    @Id
    @Column(name = "alu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "alumno")
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "alumno")
    private List<NotaCurso> notasCurso;

    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "per_id", unique = true)
    private Persona persona;

    @Column(name = "alu_estado", nullable = false)
    private String estado;

    public Alumno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<NotaCurso> getNotasCurso() {
        return notasCurso;
    }

    public void setNotasCurso(List<NotaCurso> notasCurso) {
        this.notasCurso = notasCurso;
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
