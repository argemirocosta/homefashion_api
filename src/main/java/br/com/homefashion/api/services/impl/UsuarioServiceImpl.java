package br.com.homefashion.api.services.impl;

import br.com.homefashion.api.domain.Usuario;
import br.com.homefashion.api.repository.UsuarioRepository;
import br.com.homefashion.api.services.UsuarioService;
import br.com.homefashion.api.services.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscar(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return usuario;
        }
        throw new UsuarioNaoEncontradoException();

    }

    @Override
    public Usuario salvar(Usuario usuario){
        usuario.setId(null);

        return usuarioRepository.save(usuario);

    }

    @Override
    public void deletar(Integer id){
        try {
            usuarioRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new UsuarioNaoEncontradoException();
        }
    }

    @Override
    public void alterar(Usuario usuario){
        verificarSeUsuarioExiste(usuario);
        usuarioRepository.save(usuario);
    }

    private void verificarSeUsuarioExiste(Usuario usuario){
        buscar(usuario.getId());
    }

}
