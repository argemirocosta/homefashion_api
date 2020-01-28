package br.com.homefashion.api.services;

import br.com.homefashion.api.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Optional<Usuario> buscar(Integer id);

    Usuario salvar(Usuario usuario);

    void deletar(Integer id);

    void alterar(Usuario usuario);

}
