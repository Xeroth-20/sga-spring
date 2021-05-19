package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "periodo")
public class Periodo implements Serializable {

    @Id
    @Column(name = "prd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ae_id")
    private AnoEscolar anoEscolar;

    @Column(name = "prd_nombre", nullable = false)
    private String nombre;

    @Column(name = "prd_estado", nullable = false)
    private String estado;

    public Periodo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnoEscolar getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(AnoEscolar anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
