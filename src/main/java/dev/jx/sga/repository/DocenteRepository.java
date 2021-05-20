package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Docente;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Long> {
}
