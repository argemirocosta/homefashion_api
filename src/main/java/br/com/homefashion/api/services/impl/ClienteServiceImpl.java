package br.com.homefashion.api.services.impl;

import br.com.homefashion.api.domain.Cliente;
import br.com.homefashion.api.repository.ClienteRepository;
import br.com.homefashion.api.services.ClienteService;
import br.com.homefashion.api.services.exceptions.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscar(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isEmpty()){
            throw new ClienteNaoEncontradoException();
        }

        return cliente;
    }

    public Cliente salvar(Cliente cliente){
        cliente.setId(null);

        return clienteRepository.save(cliente);

    }

    public void deletar(Integer id){
        try {
            clienteRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ClienteNaoEncontradoException();
        }
    }

    public void alterar(Cliente cliente){
        verificarSeClienteExiste(cliente);
        clienteRepository.save(cliente);
    }

    private void verificarSeClienteExiste(Cliente cliente){
        buscar(cliente.getId());
    }

    public List<Cliente> consultarClientesPorUsuario(Integer codigoUsuario) {
        return clienteRepository.consultarClientesPorUsuario(codigoUsuario);
    }

}
