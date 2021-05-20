package dev.jx.sga.service;

import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.sga.entity.Docente;
import dev.jx.sga.repository.DocenteRepository;
import dev.jx.sga.repository.UsuarioRolRepository;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    @Transactional
    public <S extends Docente> S save(S object) {
        object.getPersona().setFechaRegistro(LocalDate.now());
        object.getPersona().getTelefonos().forEach((telefono) -> {
            telefono.setPersona(object.getPersona());
        });
        object.getPersona().getUsuario().setPersona(object.getPersona());
        object.getPersona().getUsuario().setFechaRegistro(LocalDateTime.now());
        object.getPersona().getUsuario().setEstado("Habilitado");
        this.usuarioRolRepository.findByNombre("Docente").ifPresent((usuarioRol) -> {
            object.getPersona().getUsuario().setRol(usuarioRol);
        });

        return this.docenteRepository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Docente> findById(Long id) {
        return this.docenteRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Docente> findAll() {
        return this.docenteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return this.docenteRepository.count();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.docenteRepository.deleteById(id);
    }
}
