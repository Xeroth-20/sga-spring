package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "nota_criterio")
public class NotaCriterio implements Serializable {

    @Id
    @Column(name = "ncr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cev_id")
    private CriterioEv criterioEv;

    @ManyToOne(optional = false)
    @JoinColumn(name = "np_id")
    private NotaPeriodo notaPeriodo;

    @Column(name = "ncr_puntos")
    private Float puntos;
}
