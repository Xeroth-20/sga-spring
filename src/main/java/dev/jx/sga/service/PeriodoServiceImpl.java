package dev.jx.sga.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.jx.sga.entity.Periodo;
import dev.jx.sga.repository.PeriodoRepository;

@Service
public class PeriodoServiceImpl implements PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Override
    public <S extends Periodo> S save(S object) {
        return this.periodoRepository.save(object);
    }

    @Override
    public Optional<Periodo> findById(Long id) {
        return this.periodoRepository.findById(id);
    }

    @Override
    public Iterable<Periodo> findAll() {
        return this.periodoRepository.findAll();
    }

    @Override
    public long count() {
        return this.periodoRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        this.periodoRepository.deleteById(id);
    }
}
