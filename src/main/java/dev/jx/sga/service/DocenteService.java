package dev.jx.sga.service;

import java.util.Optional;
import dev.jx.sga.entity.Docente;

public interface DocenteService extends CrudService<Docente, Long> {
    public Optional<Docente> findDocenteByPersona_Dni(String dni);

}
