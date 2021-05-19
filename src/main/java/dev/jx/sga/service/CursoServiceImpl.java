package dev.jx.sga.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.sga.entity.Curso;
import dev.jx.sga.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional
    public <S extends Curso> S save(S object) {
        return this.cursoRepository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return this.cursoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Curso> findAll() {
        return this.cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return this.cursoRepository.count();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.cursoRepository.deleteById(id);
    }
}
