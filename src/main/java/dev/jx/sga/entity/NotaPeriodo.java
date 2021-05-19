package dev.jx.sga.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "nota_periodo")
public class NotaPeriodo implements Serializable {

    @Id
    @Column(name = "np_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "notaPeriodo")
    private List<NotaCriterio> notasCriterio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "prd_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cur_id", referencedColumnName = "cur_id"),
            @JoinColumn(name = "alu_id", referencedColumnName = "alu_id")
    })
    private NotaCurso notaCurso;

    @Column(name = "np_promedio")
    private Float promedio;
}
