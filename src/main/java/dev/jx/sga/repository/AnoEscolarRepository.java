package dev.jx.sga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.AnoEscolar;

@Repository
public interface AnoEscolarRepository extends CrudRepository<AnoEscolar, Long> {
}
