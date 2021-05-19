package dev.jx.sga.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dev.jx.sga.entity.CriterioEv;
import dev.jx.sga.repository.CriterioEvRepository;

@Service
public class CriterioEvServiceImpl implements CriterioEvService {

    @Autowired
    private CriterioEvRepository criterioEvRepository;

    @Override
    @Transactional
    public <S extends CriterioEv> S save(S object) {
        return this.criterioEvRepository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CriterioEv> findById(Long id) {
        return this.criterioEvRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<CriterioEv> findAll() {
        return this.criterioEvRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return this.criterioEvRepository.count();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.criterioEvRepository.deleteById(id);
    }
}
