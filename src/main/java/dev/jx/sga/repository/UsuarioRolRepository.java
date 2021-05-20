package dev.jx.sga.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.jx.sga.entity.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRol, Long> {

    public Optional<UsuarioRol> findByNombre(String nombre);
}
