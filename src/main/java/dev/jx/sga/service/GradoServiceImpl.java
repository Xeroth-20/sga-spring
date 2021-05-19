package dev.jx.sga.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import dev.jx.sga.entity.Grado;
import dev.jx.sga.repository.GradoRepository;

@Service
public class GradoServiceImpl implements GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    @Override
    public <S extends Grado> S save(S object) {
        return this.gradoRepository.save(object);
    }

    @Override
    public Optional<Grado> findById(Long id) {
        return this.gradoRepository.findById(id);
    }

    @Override
    public Iterable<Grado> findAll() {
        return this.gradoRepository.findAll();
    }

    @Override
    public long count() {
        return this.gradoRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        this.gradoRepository.deleteById(id);
    }
}
