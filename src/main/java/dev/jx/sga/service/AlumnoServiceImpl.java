package dev.jx.sga.service;

import java.util.Optional;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.sga.entity.Alumno;
import dev.jx.sga.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    @Transactional
    public <S extends Alumno> S save(S object) {
        object.getPersona().setFechaRegistro(LocalDate.now());
        object.getPersona().getTelefonos().forEach((telefono) -> {
            telefono.setPersona(object.getPersona());
        });
        return this.alumnoRepository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id) {
        return this.alumnoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll() {
        return this.alumnoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return this.alumnoRepository.count();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.alumnoRepository.deleteById(id);
    }
}
