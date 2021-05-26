package dev.jx.sga.service;

import java.util.Optional;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import dev.jx.sga.entity.CursoDocente;
import dev.jx.sga.entity.CursoDocenteId;
import dev.jx.sga.repository.CursoDocenteRepository;

@Service
public class CursoDocenteServiceImpl implements CursoDocenteService {

    @Autowired
    private CursoDocenteRepository cursoDocenteRepository;

    @Override
    public <S extends CursoDocente> S save(S object) {
        object.setFechaAsignacion(LocalDate.now());
        return this.cursoDocenteRepository.save(object);
    }

    @Override
    public Optional<CursoDocente> findById(CursoDocenteId cursoDocenteId) {
        return this.cursoDocenteRepository.findById(cursoDocenteId);
    }

    @Override
    public Iterable<CursoDocente> findAll() {
        return this.cursoDocenteRepository.findAll();
    }

    @Override
    public long count() {
        return this.cursoDocenteRepository.count();
    }

    @Override
    public void deleteById(CursoDocenteId cursoDocenteId) {
        this.cursoDocenteRepository.deleteById(cursoDocenteId);
    }
}
