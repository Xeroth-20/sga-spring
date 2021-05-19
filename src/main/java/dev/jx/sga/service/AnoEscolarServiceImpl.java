package dev.jx.sga.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import dev.jx.sga.entity.AnoEscolar;
import dev.jx.sga.repository.AnoEscolarRepository;

@Service
public class AnoEscolarServiceImpl implements AnoEscolarService {

    @Autowired
    private AnoEscolarRepository anoEscolarRepository;

    @Override
    public <S extends AnoEscolar> S save(S object) {
        return this.anoEscolarRepository.save(object);
    }

    @Override
    public Optional<AnoEscolar> findById(Long id) {
        return this.anoEscolarRepository.findById(id);
    }

    @Override
    public Iterable<AnoEscolar> findAll() {
        return this.anoEscolarRepository.findAll();
    }

    @Override
    public long count() {
        return this.anoEscolarRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        this.anoEscolarRepository.deleteById(id);
    }
}
