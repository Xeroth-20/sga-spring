package dev.jx.sga.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import dev.jx.sga.entity.Usuario;
import dev.jx.sga.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public <S extends Usuario> S save(S object) {
        return this.usuarioRepository.save(object);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return this.usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> findByAliasAndClave(String alias, String clave) {
        return this.usuarioRepository.findByAliasAndClave(alias, clave);
    }

    @Override
    public Iterable<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public long count() {
        return this.usuarioRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}
