package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Matricula;
import dev.jx.sga.entity.MatriculaId;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, MatriculaId> {

    public Iterable<Matricula> findAllByAlumno_Id(Long id);

    public Iterable<Matricula> findAllBySeccion_Id(Long id);
}
