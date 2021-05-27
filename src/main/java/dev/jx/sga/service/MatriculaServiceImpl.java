package dev.jx.sga.service;

import java.util.Optional;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import dev.jx.sga.entity.Matricula;
import dev.jx.sga.entity.MatriculaId;
import dev.jx.sga.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public <S extends Matricula> S save(S object) {
        object.setFechaInscripcion(LocalDate.now());
        return this.matriculaRepository.save(object);
    }

    @Override
    public Optional<Matricula> findById(MatriculaId matriculaId) {
        return this.matriculaRepository.findById(matriculaId);
    }

    @Override
    public Iterable<Matricula> findAll() {
        return this.matriculaRepository.findAll();
    }

    @Override
    public Iterable<Matricula> findAllByAlumno_Id(Long id) {
        return this.matriculaRepository.findAllByAlumno_Id(id);
    }

    @Override
    public Iterable<Matricula> findAllBySeccion_Id(Long id) {
        return this.matriculaRepository.findAllBySeccion_Id(id);
    }

    @Override
    public long count() {
        return this.matriculaRepository.count();
    }

    @Override
    public void deleteById(MatriculaId matriculaId) {
        this.matriculaRepository.deleteById(matriculaId);
    }
}
