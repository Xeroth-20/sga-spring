package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Grado;

@Repository
public interface GradoRepository extends CrudRepository<Grado, Long> {
}
