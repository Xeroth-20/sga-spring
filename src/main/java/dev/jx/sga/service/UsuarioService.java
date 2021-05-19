package dev.jx.sga.service;

import java.util.Optional;
import dev.jx.sga.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
    public Optional<Usuario> findByAliasAndClave(String alias, String clave);
}
