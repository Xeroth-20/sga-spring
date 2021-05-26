package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.CursoDocente;
import dev.jx.sga.entity.CursoDocenteId;

@Repository
public interface CursoDocenteRepository extends CrudRepository<CursoDocente, CursoDocenteId> {
}
