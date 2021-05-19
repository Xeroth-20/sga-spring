package dev.jx.sga.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "nota_curso")
public class NotaCurso implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "cur_id")
    private Curso curso;

    @Id
    @ManyToOne
    @JoinColumn(name = "alu_id")
    private Alumno alumno;

    @OneToMany(mappedBy = "notaCurso")
    private List<NotaPeriodo> notasPeriodo;

    @Column(name = "nc_promedio_final")
    private Float promedioFinal;
}
