package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "telefono")
public class Telefono implements Serializable {

    @Id
    @Column(name = "tel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "per_id")
    private Persona persona;

    @Column(name = "tel_numero", nullable = false)
    private String numero;
}
