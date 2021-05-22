package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class MatriculaId implements Serializable {

    @Column(name = "ae_id")
    private Long anoEscolarId;

    @Column(name = "au_id")
    private Long alumnoId;

    public MatriculaId() {
    }

    public Long getAnoEscolarId() {
        return anoEscolarId;
    }

    public void setAnoEscolarId(Long anoEscolarId) {
        this.anoEscolarId = anoEscolarId;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }
}
