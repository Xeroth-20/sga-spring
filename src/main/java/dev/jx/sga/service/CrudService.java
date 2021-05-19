package dev.jx.sga.service;

import java.util.Optional;

public interface CrudService<T, ID> {

    public <S extends T> S save(S object);

    public Optional<T> findById(ID id);

    public Iterable<T> findAll();

    public long count();

    public void deleteById(ID id);
}
