package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.Periodo;

@Repository
public interface PeriodoRepository extends CrudRepository<Periodo, Long> {
}
