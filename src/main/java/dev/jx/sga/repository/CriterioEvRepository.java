package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.CriterioEv;

@Repository
public interface CriterioEvRepository extends CrudRepository<CriterioEv, Long> {
}
