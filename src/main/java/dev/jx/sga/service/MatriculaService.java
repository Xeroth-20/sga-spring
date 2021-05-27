package dev.jx.sga.service;

import dev.jx.sga.entity.Matricula;
import dev.jx.sga.entity.MatriculaId;

public interface MatriculaService extends CrudService<Matricula, MatriculaId> {

    public Iterable<Matricula> findAllByAlumno_Id(Long id);

    public Iterable<Matricula> findAllBySeccion_Id(Long id);
}
