package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
}
