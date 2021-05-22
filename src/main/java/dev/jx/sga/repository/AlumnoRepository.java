package dev.jx.sga.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    public Optional<Alumno> findAlumnoByPersona_Dni(String dni);
}
