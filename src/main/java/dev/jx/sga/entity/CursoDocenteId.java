package dev.jx.sga.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class CursoDocenteId implements Serializable {

    @Column(name = "cur_id")
    private Long cursoId;

    @Column(name = "sec_id")
    private Long seccionId;

    @Column(name = "doc_id")
    private Long docenteId;

    public CursoDocenteId() {
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Long seccionId) {
        this.seccionId = seccionId;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }
}
