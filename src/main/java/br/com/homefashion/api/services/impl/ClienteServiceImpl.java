package br.com.homefashion.api.services.impl;

import br.com.homefashion.api.domain.Cliente;
import br.com.homefashion.api.repository.ClienteRepository;
import br.com.homefashion.api.services.ClienteService;
import br.com.homefashion.api.services.exceptions.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Page<Cliente> listar(Pageable paginacao){
        return clienteRepository.findAll(paginacao);
    }

    @Override
    public Optional<Cliente> buscar(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            return cliente;
        }
        throw new ClienteNaoEncontradoException();

    }

    @Override
    public Cliente salvar(Cliente cliente){
        cliente.setId(null);

        return clienteRepository.save(cliente);

    }

    @Override
    public void deletar(Integer id){
        try {
            clienteRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ClienteNaoEncontradoException();
        }
    }

    @Override
    public void alterar(Cliente cliente){
        verificarSeClienteExiste(cliente);
        clienteRepository.save(cliente);
    }

    private void verificarSeClienteExiste(Cliente cliente){
        buscar(cliente.getId());
    }

    @Override
    public List<Cliente> consultarClientesPorUsuario(Integer codigoUsuario) {
        return clienteRepository.consultarClientesPorUsuario(codigoUsuario);
    }

    @Override
    public List<Cliente> consultarClientesPorNomeUsuario(String nomeUsuario) {
        return clienteRepository.findByUsuario_Nome(nomeUsuario);
    }

}
