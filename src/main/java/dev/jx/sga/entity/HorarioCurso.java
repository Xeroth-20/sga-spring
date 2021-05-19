package dev.jx.sga.entity;

import java.time.LocalTime;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "horario_curso")
public class HorarioCurso implements Serializable {

    @Id
    @Column(name = "hc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "cur_id", referencedColumnName = "cur_id"),
            @JoinColumn(name = "sec_id", referencedColumnName = "sec_id"),
            @JoinColumn(name = "doc_id", referencedColumnName = "doc_id")
    })
    private CursoDocente cursoDocente;

    @Column(name = "hc_dia", nullable = false)
    private String dia;

    @Column(name = "hc_hora_ini", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hc_hora_fin", nullable = false)
    private LocalTime horaFin;
}
