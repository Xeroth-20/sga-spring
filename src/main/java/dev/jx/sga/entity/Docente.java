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

    @OneToOne(optional = false)
    @JoinColumn(name = "per_id", unique = true)
    private Persona persona;

    @Column(name = "doc_estado", nullable = false)
    private String estado;
}
