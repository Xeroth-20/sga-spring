package dev.jx.sga.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.jx.sga.entity.Seccion;
import dev.jx.sga.repository.SeccionRepository;

@Service
public class SeccionServiceImpl implements SeccionService {

    @Autowired
    private SeccionRepository seccionRepository;

    @Override
    public <S extends Seccion> S save(S object) {
        return this.seccionRepository.save(object);
    }

    @Override
    public Optional<Seccion> findById(Long id) {
        return this.seccionRepository.findById(id);
    }

    @Override
    public Iterable<Seccion> findAll() {
        return this.seccionRepository.findAll();
    }

    @Override
    public long count() {
        return this.seccionRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        this.seccionRepository.deleteById(id);
    }
}
