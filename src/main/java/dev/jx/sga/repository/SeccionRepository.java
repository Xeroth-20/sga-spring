package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Seccion;

@Repository
public interface SeccionRepository extends CrudRepository<Seccion, Long> {
}
