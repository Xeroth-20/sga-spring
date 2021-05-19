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
    private List<NotaCurso> notasCurso;

    @OneToOne(optional = false)
    @JoinColumn(name = "per_id", unique = true)
    private Persona persona;

    @Column(name = "alu_estado", nullable = false)
    private String estado;
}
