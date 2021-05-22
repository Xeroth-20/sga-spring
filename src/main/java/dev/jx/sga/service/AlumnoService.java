package dev.jx.sga.service;

import java.util.Optional;

import dev.jx.sga.entity.Alumno;

public interface AlumnoService extends CrudService<Alumno, Long> {

    public Optional<Alumno> findAlumnoByPersona_Dni(String dni);
}
