package dev.jx.sga.service;

import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.sga.entity.Docente;
import dev.jx.sga.entity.Persona;
import dev.jx.sga.entity.Usuario;
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
        Persona persona = object.getPersona();
        Usuario usuario = persona.getUsuario();
        persona.setFechaRegistro(LocalDate.now());
        persona.getTelefonos().forEach((telefono) -> {
            telefono.setPersona(persona);
        });
        usuario.setPersona(persona);
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setEstado("Habilitado");
        this.usuarioRolRepository.findByNombre("Docente").ifPresent(usuario::setRol);

        return this.docenteRepository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Docente> findById(Long id) {
        return this.docenteRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Docente> findDocenteByPersona_Dni(String dni) {
        return this.docenteRepository.findDocenteByPersona_Dni(dni);
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
