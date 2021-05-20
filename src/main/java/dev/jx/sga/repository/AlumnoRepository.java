package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
