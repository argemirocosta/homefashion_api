package br.com.homefashion.api.services;

import br.com.homefashion.api.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listar();

    Optional<Cliente> buscar(Integer id);

    Cliente salvar(Cliente cliente);

    void deletar(Integer id);

    void alterar(Cliente cliente);

    List<Cliente> consultarClientesPorUsuario(Integer codigoUsuario);

    List<Cliente> consultarClientesPorNomeUsuario(String nomeUsuario);

}
